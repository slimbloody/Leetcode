from itertools import accumulate as acc
class Solution:
    def balancedStringSplit(self, s: str) -> int:
        return list(acc(1 if c == 'L' else -1 for c in s)).count(0)
