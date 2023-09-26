package 수학;

public class Test {
    public static void main(String[] args) {
        final double r = 1;

        double sugux = 0;
        double suguy = 0;

        double targetx = 5;
        double targety = -3;

        double pocketx = 10;
        double pockety = -10;

        double angleTargetToPocket = Math.atan2(pockety - targety, pocketx - targetx);

        double dx = 2 * r * Math.cos(angleTargetToPocket);
        double dy = 2 * r * Math.sin(angleTargetToPocket);

        double finalx = targetx + dx;
        double finaly = targety + dy;

        double answer = 90 - Math.toDegrees(Math.atan2(finaly - suguy, finalx - sugux));
        double firstangle = Math.toDegrees(Math.atan2(targety - suguy, targetx - sugux));

        System.out.println(firstangle);
        System.out.println(answer);
    }
}
