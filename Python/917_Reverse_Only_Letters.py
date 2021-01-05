class Solution:
    def reverseOnlyLetters(self, S):
        """
        :type S: str
        :rtype: str
        """
        return self.sol_2(S)

    def sol_1(self, S):
        character_array = list()
        for c in S:
            if c.isalpha():
                character_array.append(c)

        character_array = character_array[::-1]

        index = 0
        join_array = list()
        for c in S:
            if c.isalpha():
                join_array.append(character_array[index])
                index += 1
            else:
                join_array.append(c)

        return ''.join(join_array)

    # Reverse Pointer
    def sol_2(self, S):
        ans = []
        j = len(S) - 1
        for i, x in enumerate(S):
            if x.isalpha():
                while not S[j].isalpha():
                    j -= 1
                ans.append(S[j])
                j -= 1
            else:
                ans.append(x)
        return "".join(ans)

def verify(verify_s, correct_s):
    s = Solution()
    string = s.reverseOnlyLetters(verify_s)
    print(string)
    assert string == correct_s

s = Solution()
verify("ab-cd", "dc-ba")
verify("a-bC-dEf-ghIj", "j-Ih-gfE-dCba")
verify("Test1ng-Leet=code-Q!", "Qedo1ct-eeLg=ntse-T!")
verify("-=", "-=")
verify("-=abc", "-=cba")
verify("abc-=", "cba-=")
verify("-abc=", "-cba=")
verify("", "")
























