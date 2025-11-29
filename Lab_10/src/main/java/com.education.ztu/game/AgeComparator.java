/**
 * A comparator implementation for comparing two Participant objects by their age.
 * This class can be used to sort Participant objects in ascending order of age.
 */
package com.education.ztu.game;

import java.util.Comparator;

public class AgeComparator implements Comparator<Participant> {

    /**
     * Compares two Participant objects based on their age.
     *
     * @param p1 the first Participant object to compare
     * @param p2 the second Participant object to compare
     * @return a negative integer, zero, or a positive integer as the first argument
     *         is less than, equal to, or greater than the second.
     */
    @Override
    public int compare(Participant p1, Participant p2) {
        return Integer.compare(p1.getAge(), p2.getAge());
    }
}

