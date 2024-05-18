package ca.rpgcraft.damageindicatorsfabric.util;

import net.minecraft.util.math.Vec3d;

public class VectorRingBuffer {
    //class RingBuffer creates a ring buffer of Vectors of a given size.
    //The buffer is filled with random Vectors.

    private int size;
    private Vec3d[] buffer;
    private int writeIndex;
    private int readIndex;

    public VectorRingBuffer(int size, VectorGenerator vectorGenerator) {
        this.size = size;
        buffer = new Vec3d[size];
        for(int i = 0; i < size; i++) {
            buffer[i] = vectorGenerator.getVector();
        }
        writeIndex = 0;
        readIndex = 0;
    }

    public Vec3d get(int index) {
        return buffer[index];
    }

    public int getSize() {
        return size;
    }

    public int getWriteIndex() {
        return writeIndex;
    }

    public int getReadIndex() {
        return readIndex;
    }

    public void set(int index, Vec3d vector) {
        buffer[index] = vector;
    }

    public Vec3d getNext() {
        Vec3d next = buffer[readIndex];
        readIndex++;
        if(readIndex >= size) {
            readIndex = 0;
        }
        return next;
    }

    public void setNext(Vec3d vector) {
        buffer[writeIndex] = vector;
        writeIndex++;
        if(writeIndex >= size) {
            writeIndex = 0;
        }
    }

    public void reset() {
        for(int i = 0; i < size; i++) {
            buffer[i] = new Vec3d(0,0,0);
        }
        writeIndex = 0;
        readIndex = 0;
    }
}
