public class FindMinMoves517 {

    public static int findMinMoves(int[] machines) {
        int n = machines.length;
        int max = 0;
        int sum = 0;
        for(int i = 0; i< n; i++) {
            sum += machines[i];
            max = Math.max(machines[i], max);
        }
        if(sum % n != 0) return -1;

        int avg = sum / n;

        for(int i = 0; i < machines.length ; i++) {
            machines[i] = machines[i] - avg;
        }

        int load = 0;
        int out = 0;
        for(int i = 0; i < machines.length; i++) {
            load += machines[i];
            out = Math.max(out, Math.max(Math.abs(load), machines[i]));
        }
        return out;
    }

    public static void main(String[] args) {
        int[] machines = {1,0,5};
        System.out.print(findMinMoves(machines));
    }
}
