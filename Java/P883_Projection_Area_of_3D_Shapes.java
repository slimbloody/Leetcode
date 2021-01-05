public class P883_Projection_Area_of_3D_Shapes {
  public int projectionArea(int[][] grid) {
    return sol1(grid);
  }
  
  public int sol1(int[][] grid) {
    int N = grid.length;
    int res = 0;
    
    for (int i = 0; i < N;  ++i) {
      int bestRow = 0;  // largest of grid[i][j]
      int bestCol = 0;  // largest of grid[j][i]
      for (int j = 0; j < N; ++j) {
        if (grid[i][j] > 0) {
          ++res;  // top shadow
        }
        bestRow = Math.max(bestRow, grid[i][j]);
        bestCol = Math.max(bestCol, grid[j][i]);
      }
      res += bestRow + bestCol;
    }
    
    return res;
  }
  
  // 顺序 链式都可以
  // nlogn // 不稳定
  // 不断输出堆顶元素, 并向下调整
  // 堆插入 将新节点放入末端然后向上调整
  void HeapSort(int[] A) {
    BuildMaxHeap(A);
    
    for (int i = A.length; i > 1; --i) {
      Swap(A, i, 1);
      AdjustDown(A, 1);
    }
  }
  
  private void Swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
  
  // void AdjustUp(int[] A, int len) {
  //   A[0] = A[k];
  //   int i = k / 2;
  //
  //   while (i > 0 && A[i] < A[0]) {
  //     A[k] = A[i];
  //     k = i;
  //     i = k / 2;
  //     A[k] = A[0];
  //   }
  // }
  
  // 初试建堆o(n)
  void BuildMaxHeap(int[] A) {
    // 取父节点
    for (int i = A.length / 2; i > 0; --i) { // 取下界
      AdjustDown(A, i);
    }
  }
  
  void AdjustDown(int[] A, int k) {
    A[0] = A[k];
    
    for (int i = 2 * k; i <= A.length; i *= 2) {
      // 范围 左右孩子哪个大
      if (i < A.length && A[i] < A[i + 1]) {
        ++i;
      }
      
      if (A[0] >= A[i]) {
        break;
      }
      else {
        A[k] = A[i];
        k = i;
      }
    }
    A[k] = A[0];
    
  }
}
