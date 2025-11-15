# ⭐ **What Is Pessimistic Locking?**

Pessimistic Locking is a concurrency control mechanism that assumes:
`Multiple transactions *will* try to modify the same data.`

So instead of allowing everyone to proceed freely (like optimistic locking), the system:

* **Locks the row immediately** when a transaction reads it
* **Blocks all other transactions** trying to read/update that row
* Ensures only one transaction can modify the data at a time

This prevents conflicts **before they even happen**, but introduces waiting/blocking.

---

# ⭐ **Real-Life Analogy**

Imagine a library where only **one person can take a book at a time**:

* Person A takes the book → lock acquired
* Person B wants the same book → must wait
* Person A finishes and returns it → lock released
* Now Person B gets the book

You avoid conflicts, but at the cost of **waiting time**.

---

# ⭐ **How Pessimistic Locking Works in JPA/Hibernate**

You apply a lock when reading the entity:

```java

@Lock(LockModeType.PESSIMISTIC_WRITE)
@Query("SELECT p FROM Product p WHERE p.id = :id")
Product lockProductForUpdate(Long id);
```

What Hibernate does under the hood:

```
SELECT *
FROM product
WHERE id = ?
FOR UPDATE;
```

This causes PostgreSQL to:

* Lock the row **immediately**
* Block other transactions until the current one **commits or rolls back**

---

# ⭐ **Code Explanation**

**Tx1**:

* Acquires lock
* Sleeps for 10 seconds
* Updates quantity

**Tx2**:

* Tries to acquire lock
* PostgreSQL forces it to wait
* Only proceeds after Tx1 commits

This guarantees that **no lost updates** can happen.
