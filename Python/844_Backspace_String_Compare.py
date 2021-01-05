def backspaceCompare(self, S, T):
    """
    :type S: str
    :type T: str
    :rtype: bool
    """
    def next_char_gen(self, s):
        count = 0

        for c in s[::-1]:
            if c == '#':
                count = count + 1
            else:
                if count > 0:
                    count = count - 1
                else:
                   yield c

    if len(S) != len(T):
        return False;

    s_gen = next_char_gen(S)
    t_gen = next_char_gen(T)

    for a, b in itertools.zip_longest(S_gen, T_gen):
        if a != b:
            return False

    return True



