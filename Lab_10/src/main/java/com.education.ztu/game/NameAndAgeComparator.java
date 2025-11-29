/**
 * Provides a comparator for comparing Participant objects based on their name and age.
 * The comparison is done first by name in lexicographical order, then by age in ascending order.
 */
package com.education.ztu.game;

import java.util.Comparator;

public class NameAndAgeComparator {

    /**
     * Returns a Comparator that compares Participant objects by their name and age.
     *
     * @return a Comparator object for comparing Participant instances
     */
    public static Comparator<Participant> getComparator() {
        return Comparator.comparing(Participant::getName)  // First, compare by name
                .thenComparing(Participant::getAge);     // Then, compare by age if names are the same
    }
}
