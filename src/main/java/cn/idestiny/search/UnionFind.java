package cn.idestiny.search;

/**
 * @Auther: FAN
 * @Date: 2018/9/2 19:44
 * @Description:
 **/
public class UnionFind {

    public int[] id;
    public int count;

    UnionFind(int n){
        count = n;
        id = new int[n];
        for (int i = 0;i<n;i++){
            id[i] = i;
        }
    }

    public int find(int p){
        assert p>=0&&p<count;
        return id[p];
    }

    public boolean isConnected(int p,int q){
        return id[p] == id[q];
    }
    public void union(int p,int q){
        int pID = find(p);
        int qID = find(q);
        if (pID == qID){
            return;
        }
        for (int i = 0;i<count;i++){
            if (id[i] == pID ){
                id[i] = qID;
            }
        }
    }

    public static void main(String[] args) {

        int n = 1000000;

        UnionFind unionFind = new UnionFind(n);

        long start = System.currentTimeMillis();

        for (int i = 0;i<n;i++){
            int a = (int) (Math.random() * n);
            int b = (int) (Math.random() * n);
            unionFind.union(a,b);
        }

        for (int i = 0;i<n;i++){
            int a = (int) (Math.random() * n);
            int b = (int) (Math.random() * n);
            unionFind.isConnected(a,b);
        }

        System.out.println(System.currentTimeMillis()-start);
    }

}
