/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

import java.util.ArrayList;
import java.util.List;

/**
 * Method to perform a merge sort on a list of Employee objects by name. This
 * method divides the list into smaller sublists, recursively sorts each
 * sublist, and then merges them back together in sorted order. Sorting is
 * performed in a case-insensitive manner to ensure consistency in the results,
 * especially for names with mixed capitalization.
 *
 * The method uses the "divide and conquer" approach of merge sort, making it
 * efficient for large lists with a time complexity of O(n log n).
 *
 * @author Mikel
 */
public class SortingAlgorithm {
    // Main method to perform Merge Sort on a list of Employee objects

    public static List<Employee> mergeSort(List<Employee> list) {
        // Base case: if the list has one or zero elements, it is already sorted
        if (list.size() <= 1) {
            return list;
        }

        // Find the middle index to split the list into two halves
        int mid = list.size() / 2;

        // Split the list into two halves: left and right
        List<Employee> left = new ArrayList<>(list.subList(0, mid));
        List<Employee> right = new ArrayList<>(list.subList(mid, list.size()));

        // Recursively sort each half, then merge the sorted halves together
        return merge(mergeSort(left), mergeSort(right));
    }

    // Helper method to merge two sorted lists of Employee objects into a single sorted list
    private static List<Employee> merge(List<Employee> left, List<Employee> right) {
        List<Employee> sortedList = new ArrayList<>(); // List to store the sorted result
        int i = 0, j = 0; // Pointers for iterating through the left and right lists

        // Loop through both lists, comparing elements and adding the smaller one to sortedList
        while (i < left.size() && j < right.size()) {
            // Compare names of the Employee objects (case-insensitive)
            if (left.get(i).getName().compareToIgnoreCase(right.get(j).getName()) <= 0) {
                // If left's current element is smaller or equal, add it to sortedList
                sortedList.add(left.get(i++));
            } else {
                // If right's current element is smaller, add it to sortedList
                sortedList.add(right.get(j++));
            }
        }

        // Add any remaining elements from the left list to sortedList
        while (i < left.size()) {
            sortedList.add(left.get(i++));
        }

        // Add any remaining elements from the right list to sortedList
        while (j < right.size()) {
            sortedList.add(right.get(j++));
        }

        // Return the merged and sorted list
        return sortedList;
    }

    // Main method to perform Merge Sort on a list of Patient objects, similar to the Employee version
    public static List<Patient> mergeSortPatients(List<Patient> list) {
        // Base case: a list with one or zero elements is already sorted
        if (list.size() <= 1) {
            return list;
        }

        // Find the middle index to split the list into two halves
        int mid = list.size() / 2;

        // Split the list into two halves: left and right
        List<Patient> left = new ArrayList<>(list.subList(0, mid));
        List<Patient> right = new ArrayList<>(list.subList(mid, list.size()));

        // Recursively sort each half, then merge the sorted halves together
        return mergePatients(mergeSortPatients(left), mergeSortPatients(right));
    }

    // Helper method to merge two sorted lists of Patient objects into a single sorted list
    private static List<Patient> mergePatients(List<Patient> left, List<Patient> right) {
        List<Patient> sortedList = new ArrayList<>(); // List to store the sorted result
        int i = 0, j = 0; // Pointers for iterating through the left and right lists

        // Loop through both lists, comparing elements and adding the smaller one to sortedList
        while (i < left.size() && j < right.size()) {
            // Compare names of the Patient objects (case-insensitive)
            if (left.get(i).getName().compareToIgnoreCase(right.get(j).getName()) <= 0) {
                // If left's current element is smaller or equal, add it to sortedList
                sortedList.add(left.get(i++));
            } else {
                // If right's current element is smaller, add it to sortedList
                sortedList.add(right.get(j++));
            }
        }

        // Add any remaining elements from the left list to sortedList
        while (i < left.size()) {
            sortedList.add(left.get(i++));
        }

        // Add any remaining elements from the right list to sortedList
        while (j < right.size()) {
            sortedList.add(right.get(j++));
        }

        // Return the merged and sorted list
        return sortedList;
    }

}
