⭐ What Is Optimistic Locking?

Optimistic Locking is a concurrency control mechanism that assumes: `Multiple transactions are unlikely to modify the
same data at the same time.`

So instead of blocking other transactions (like pessimistic locking), the system:

* Lets everyone read the data freely
* Detects conflicts at commit time
* If the record has been modified by someone else → throws an error, usually `OptimisticLockException`

This avoids database-level locks and increases performance.

⭐ Real-Life Analogy

Imagine two people editing the same Google Doc:

* Person A starts editing version 1
* Person B also starts editing version 1
* Person B finishes first → DOC becomes version 2
* Person A tries to save but sees: `This document has been updated; reload first.`

That’s optimistic locking.

⭐ How Optimistic Locking Works in JPA/Hibernate

You add a special field in your entity:
`
@Version
private Long version;
`

Hibernate will:

* Set version = 0 for new rows
* Every time an update happens → increment it (0 → 1 → 2 → ...)
* During update:
  `
  update table
  set field=?, version = version + 1
  where id=? and version=?
  `

If the version does not match, no row updates → Hibernate throws: `OptimisticLockException`