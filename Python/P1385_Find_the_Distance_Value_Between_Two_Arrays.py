def findTheDistanceValue(self, A, B, d):
    return sum(all(abs(a - b) > d for b in B) for a in A)