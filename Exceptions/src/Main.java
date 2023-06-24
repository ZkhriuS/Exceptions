public class Main {
    public static void main(String[] args) {
        /*int[] array = new int[12];
        for(int i=0; i< array.length; i++){
            array[i] = (int)(Math.random()*10)-5;
        }
        //System.out.println(length(array));
        for (int el:array) {
            System.out.print(el+" ");
        }
        System.out.println();
        printResult(find(array, 2));*/
        /*int[][] array = new int[5][5];
        for(int i=0; i< array.length; i++){
            for(int j=0; j< array[i].length; j++)
                array[i][j] = (int)(Math.random()*2);
        }
        for(int i=0; i< array.length; i++){
            for(int j=0; j< array[i].length; j++)
                System.out.print(array[i][j]+" ");
            System.out.println();
        }
        System.out.println(sumBin(array));*/
        int[] array1 = createArray(10, -50, 50);
        printArray(array1);
        int[] array2 = createArray(10, -50, 50);
        printArray(array2);
        int[] arrayDiff = differenceArray(array1, array2);
        printArray(arrayDiff);
        int[] arrayDiv = divisionArray(array1, array2);
        printArray(arrayDiv);

    }
    public static int length(int[] array){
        int min = 8;
        if(array.length<min)
            return -1;
        return array.length;
    }

    public static int find(int[] array, int value){
        if(array==null)
            return -3;
        int min = 2;
        if(array.length<min)
            return -1;
        for(int i=0; i<array.length; i++){
            if(array[i]==value)
                return i;
        }
        return -2;
    }

    public static void printResult(int code){
        switch (code){
            case -1:
                System.out.println("Длина массива меньше минимальной");break;
            case -2:
                System.out.println("Элемент не найден");break;
            case -3:
                System.out.println("Массив не создан");break;
            default:
                System.out.println("Индекс числа равен: "+code);
        }
    }

    public static int sumBin(int[][] array){
        if(array==null)
            throw new RuntimeException("Массив не создан");
        if(array.length!=array[0].length)
            throw new RuntimeException("Массив не является квадратным");
        int sum = 0;
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array[i].length; j++){
                if(Math.abs(array[i][j]/2)>0)
                    throw new RuntimeException("Массив не бинарный, элемент "+i+" "+j);
                sum+=array[i][j];
            }
        }
        return sum;
    }

    public static int[] createArray(int size, int min, int max){
        int[] array = new int[size];
        for(int i=0; i< array.length; i++){
            array[i] = (int)(Math.random()*(max-min))+min;
        }
        return array;
    }

    public static void printArray(int[] array){
        for(int i=0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    public static int[] differenceArray(int[] arr1, int[] arr2){
        if(arr1.length!= arr2.length)
            throw new RuntimeException("Входные массивы разной длины");
        int[] result = new int[arr1.length];
        for(int i=0; i<result.length; i++){
            result[i] = arr1[i] - arr2[i];
        }
        return result;
    }

    public static int[] divisionArray(int[] arr1, int[] arr2){
        if(arr1.length!= arr2.length)
            throw new RuntimeException("Входные массивы разной длины");
        int[] result = new int[arr1.length];
        for(int i=0; i<result.length; i++){
            if(arr2[i]==0)
                throw new RuntimeException("Деление на 0 не допустимо");
            result[i] = arr1[i] / arr2[i];
        }
        return result;
    }
}
