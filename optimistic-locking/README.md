# ⭐ What Is Optimistic Locking?

Optimistic Locking is a concurrency control strategy that assumes:
`Multiple transactions are unlikely to update the same document at the same time.`

So instead of blocking other operations (unlike pessimistic locking), the system:

* Allows everyone to read data freely
* Checks for conflicts only at update/commit time
* If the document was changed by someone else → throws `OptimisticLockingFailureException`

It avoids database-level locks and improves performance in read-heavy systems.

---

# ⭐ Real-Life Analogy

Think of two people editing the same Google Doc:

* Person A opens version 1
* Person B also opens version 1
* Person B saves first → document becomes version 2
* Person A tries to save version 1 → "Document updated, reload first."

This is exactly how optimistic locking works.

---

# ⭐ How Optimistic Locking Works in MongoDB (Spring Data)

MongoDB itself does **not** provide optimistic locking,
but **Spring Data MongoDB adds this feature using `@Version`**.

In your entity:

```java

@Version
private Long version;
```

Spring Data will:

* Assign `version = 0` to new documents
* Increment version on each successful update
* Only update if the version matches the current DB version

Under the hood, the update query looks like:

```
{
  "_id": "...",
  "version": 0     ← expected version
}
```

If MongoDB finds **no document matching this version**, it means a conflict occurred →
Spring throws **OptimisticLockingFailureException**.

---

# ⭐ Code exaplanation

`simulateConflict()` method simulates two concurrent transactions:

### **Transaction 1 (p1)**

Reads document at version `0`.

### **Transaction 2 (p2)**

Reads document at version `0`
Updates price → write succeeds → version becomes `1`.

### **Transaction 1 tries to update**

But it still sends version `0`.

Spring detects:

> “This version is stale. Someone already updated this document.”

So it throws:

```
OptimisticLockingFailureException
```

Which the code catches and print:

```
Conflict detected! Someone else modified this record.
```

---

Optimistic locking fits perfectly because it:

* Avoids blocking
* Keeps operations lightweight
* Prevents lost updates without using database locks
