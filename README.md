# clinic

# FAQ and Comments:

Should I support human-readable recurrence patterns?

- Recurrence patterns format is an implementation detail and is not required to be humanly readable
  `I left recurrence patterns like cron expresion (0 0 0 * * *). +
  In my opinion, cron expresion covered all cases, and we have a good API/ libraries for it. +
  In case I miss something please let me now
  `

Should I create all or some of the treatment tasks ahead of time?

- No need. You need the treatment task to exist in the DB when the task is active.
- Creating too many tasks ahead of time can be a scalability issue"
  ` Changes were made. Depending on how the system will used in the future, +
  The task can be implemented differently. (We can discuss it on an Interview).+
  If you have some questions/suggestions please let me know.
  `

It is implemented in the easiest way.
A lot of corner cases are not covered.
Also, tests are not implemented.