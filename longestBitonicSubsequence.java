class longestBitonicSubsequence{

    public static int solution(int[] arr){
        int[] lis = new int[arr.length];

        for(int i=0; i<arr.length; i++){
            int max = 0;

            for(int j=0; j<i; j++){
                if(arr[j] < arr[i]){
                    if(lis[j] > max){
                        max = lis[j];
                    }
                }
            }

            lis[i] = max+1;
        }

        int[] lds = new int[arr.length];

        for(int i=arr.length-1; i>=0; i--){
            int max = 0;

            for(int j=arr.length-1; j>i; j--){
                if(arr[j] < arr[i]){
                    if(lds[j] > max){
                        max = lds[j];
                    }
                }
            }

            lds[i] = max+1;
        }

        int omax = 0;
        for(int i=0; i<arr.length; i++){
            if(lis[i] + lds[i] > omax){
                omax = lis[i] + lds[i] - 1;
            }
        }

        return omax;

    }

    public static void main(String[] args){
        int[] arr = {10,22,9,33,21,50,41,60,80,1};

        System.out.println(solution(arr));
    }
}
