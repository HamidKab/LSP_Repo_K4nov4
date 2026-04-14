prompt
Create an Instructor level Junit test suite to run edge case testing and confirm code logic

response
Test coverage — 52 tests across all 14 methods:

Group	Tests	Edge Cases Covered
clear()	2	Populated set, already-empty set
isEmpty()	3	New set, after add, after clear
length()	4	Empty, multiple adds, duplicate add, after remove
add()	4	Empty set, duplicate, negative, zero
remove()	3	Existing element, non-existent, empty set
contains()	4	Present, absent, empty set, negative
largest()	5	Empty (throws), singleton, multiple, all-negative, mixed
smallest()	5	Empty (throws), singleton, multiple, all-negative, mixed
equals()	6	Identical, order-independent, different size, different content, both empty, one empty
union()	5	Overlapping, disjoint, one empty, both empty, no mutation
intersect()	6	Overlapping, disjoint, one empty, both empty, identical, no mutation
diff()	6	Overlapping, disjoint, superset b, empty b, both empty, no mutation
complement()	6	Overlapping, disjoint, b subset, empty b, both empty, no mutation
toString()	5	Empty, singleton, insertion order scrambled, negatives, mixed