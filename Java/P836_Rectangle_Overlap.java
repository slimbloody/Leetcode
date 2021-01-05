public class P836_Rectangle_Overlap {
  public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
    return sol1(rec1, rec2);
  }
  
//  De Morgan's Law tells us that the following are equivalent.
//  An easy way to remember De Morgan's is by the saying to split the bar and
//  change the operation; that is to distribute negation and change the
//  boolean operator in this example.

//public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
//  return !(rec1[2] <= rec2[0] ||   // left
//      rec1[3] <= rec2[1] ||   // bottom
//      rec1[0] >= rec2[2] ||   // right
//      rec1[1] >= rec2[3]);    // top
//}
  
  public boolean sol1(int[] rec1, int[] rec2) {
    return rec1[2] > rec2[0] &&   // left
        rec1[3] > rec2[1] &&   // bottom
        rec1[0] < rec2[2] &&   // right
        rec1[1] < rec2[3];     // top
  }
  
//  1D overlap ==> 2D overlap
//  Case-1: Rec2 intersects with Rec1 on top right corner
//  Case-2: Rec2 intersects with Rec1 on top left corner
//  Case-3: Rec2 intersects with Rec1 on bottom left corner
//  Case-4: Rec2 intersects with Rec1 on bottom right corner
//  bool case1 = (x1 < x4 && x3 < x2 && y1 < y4 && y3 < y2); //top right intersection
//  bool case2 = (x3 < x2 && x1 < x4 && y1 < y4 && y3 < y2); //top left intersection
//  bool case3 = (x3 < x2 && x1 < x4 && y3 < y2 && y4 < y1); //bottom left intersection
//  bool case4 = (x1 < x4 && x3 < x2 && y3 < y2 && y4 < y1); //bottom right intersection
//  if you look carefully in all cases we have same 4 comparisons
//  simplify it
  public boolean sol2(int[] rec1, int[] rec2) {
    return true;
  }
}
