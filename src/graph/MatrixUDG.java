package graph;

public class MatrixUDG {


    public static void floyd(int[][] weight,int[][] path,String[] vexes){
        int vexCnt = vexes.length;
        //第一层循环，代表把顶点加入中间路径中
        for(int i = 0; i < vexCnt;i++){
            //内两层是对权重的二位数组进行从左到右从上到下遍历
            for(int j = 0; j < vexCnt;j++){
                for(int k = 0; k < vexCnt;k++){
                    if(weight[j][k] > weight[j][i] + weight[i][k]){
                         weight[j][k] = weight[j][i] + weight[i][k];
                         path[j][k] = i;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] vexes ={"A","B","C","D"};
        int[][] edges = {
                {0,5,99,7},
                {99,0,4,2},
                {3,3,0,2},
                {99,99,1,0}
        };
        int[][] path = {
                {-1,-1,-1,-1},
                {-1,-1,-1,-1},
                {-1,-1,-1,-1},
                {-1,-1,-1,-1}
        };

        floyd(edges,path,vexes);

        System.out.println(edges);
        System.out.println(path);
    }
}