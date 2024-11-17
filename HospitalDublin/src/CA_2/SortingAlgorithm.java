/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;
//This are the imports that we use in this class

import java.util.ArrayList;
import java.util.List;

/**
 * This method divides the list into smaller sub lists, recursively sorts each
 * sub list, and then merges them back together in sorted order. In this case
 * the sort is performed in a case-insensitive manner to ensure consistency in
 * the results, especially for names with mixed capitalization. The method uses
 * the "divide and conquer" approach of merge sort, making it efficient for
 * large lists with a time complexity of O(n log n). In the hospital management
 * system, we chose Merge Sort for sorting employee and patient lists because it
 * provides a perfect balance of efficiency and reliability. Since the system
 * deals with potentially large data sets, Merge Sort will ensures optimal
 * performance with its O(n log n) complexity, making it suitable for handling
 * the sorting of numerous records efficiently. Another critical reason is that
 * Merge Sort is a stable algorithm, meaning that it maintains the relative
 * order of entries with the same key (in this case, names). This is especially
 * important in a hospital context where multiple employees or patients might
 * share the same name. For instance, if two nurses named "Mikel Pinto" work in
 * different departments, Merge Sort ensures their respective information
 * remains intact and correctly ordered, will avoiding any confusion. Other
 * sorting algorithms, such as Quick Sort, were considered, but Quick Sort is
 * not stable and could disrupt the ordering of records with duplicate names.
 * While Heap Sort is efficient, it does not guarantee stability, which is
 * essential for our system to preserve data integrity. Merge Sort is also easy
 * to integrate into the project's structure, allowing seamless recursive
 * division of the list into smaller sub lists and subsequent merging. This
 * approach ensures that names are alphabetically sorted, simplifying searches
 * and maintaining consistency. Alternative algorithms like Bubble Sort were
 * discarded because they are too slow for large data sets and do not align with
 * the system's requirements.
 *
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
