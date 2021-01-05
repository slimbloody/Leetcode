public class P1025_Divisor_Game {
  public boolean divisorGame(int N) {
    return sol1(N);
  }
  
  public boolean sol1(int N) {
    return N % 2 == 0;
  }
  
  // https://leetcode.com/problems/divisor-game/discuss/274606/JavaC%2B%2BPython-return-N-2-0
  
  /*
  todo: math proof
  先证当N为偶数时爱丽斯赢。
  规定爱丽斯的策略是只选取奇数的n，由于1是奇数，也是任何数的因子，不妨设爱丽斯总是选取n=1。
  当轮到爱丽斯选n时，n=1，N=N-1，N迭代化为奇数。
  轮到鲍勃取n，由于此时n为奇数，考虑到奇数的因子必定为奇数，鲍勃无论如何选取n，n总为奇数，因此N=N-n=奇数-奇数，N迭代化为偶数。
  轮到爱丽斯选n，N仍为偶数，显然，当爱丽斯使用这种策略选取n时，爱丽斯手上的N总为偶数。N不断迭代变小且总是正偶数，最终爱丽斯会获取等于2的N值。此时爱丽斯胜。

  再证N为奇数时爱丽斯必输。由于N是奇数，N的因子也必为奇数，爱丽斯无论如何选取n都会使鲍勃获得偶数的N。此时鲍勃只需要使用与之前相同的策略就可以战胜爱丽斯。
   */
}
