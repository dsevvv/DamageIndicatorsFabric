package ca.rpgcraft.damageindicatorsfabric.util;

import net.minecraft.util.math.Vec3d;

import java.util.Random;

public class VectorGenerator {

    private Vec3d vector;
    private double x;
    private double y;
    private double z;

    public void run() {
        Random rand = new Random();
        double horiRange = .25;
        double vertRange = .15;

        if(rand.nextInt(2) == 0)
        {
            x = rand.nextDouble(horiRange);
        }
        else
        {
            x = -(rand.nextDouble(horiRange));
        }

        if(rand.nextInt(2) == 0)
        {
            z = rand.nextDouble(horiRange);
        }
        else
        {
            z = -(rand.nextDouble(horiRange));
        }

        y = rand.nextDouble(vertRange)+.1;

        vector = new Vec3d(x, y, z);
    }

    public Vec3d getVector()
    {
        run();
        return vector;
    }

    public double getX(){return x;}

    public double getY(){return y;}

    public double getZ(){return z;}
}
