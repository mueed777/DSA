/*
Hash -> map, set
map -> Hashmap, LinkedHashmap(insertion ordered), Treemap(sorted)
set -> Hashset(no duplicates), LinkedHashset(insertion ordered, no duplicates), 
                                            Treeset(sorted, no duplicates)

HashMap - (key, value) - keys are unique
put(key, value) - O(1)
get(key) - O(1)
containsKey(key) - O(1)
remove(key) - O(1)
size()
isEmpty()
keySet() - get a collection of all the key
example: Set<Integer> keys = hashmap.keySet();

LinkedHashmap(ordered) - (key, value) - keys are unique

Treemap - (key, value) - keys are sorted
put(), get(), remove() are O(logn)

Hashset - null is allowed
add(key) - O(1)
contains(key) - O(1)
remove(key) - O(1)
recommended to use Iterator to iterate through Hashset

LinkedHashset - null is allowed

Treesert - sorted so null NOT allowed
 */

import java.util.*;

public class Hashing {
    public static void main(String[] args) {
        HashMap<String, String> hasmap = new HashMap<>();
        hasmap.put("Chennai", "Bengaluru");
        hasmap.put("Mumbai", "Delhi");
        hasmap.put("Goa", "Chennai");
        hasmap.put("Delhi", "Goa");

        findItinerary(hasmap);
    }

    /*
     * Majority element
     * given an integer array of size n, find all elements that appear more than
     * [n/3] times
     * ex: nums[] = {1, 3, 2, 5, 1, 3, 1, 5, 1}
     * // 1
     * ex2: nums[] = {1, 2}
     * // 1, 2
     * 
     * time complexity: O(n)
     * space complexity: O(n)
     */
    public static void majorityElement(int arr[]) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int number = arr[i];
            if (hashmap.containsKey(number)) {
                hashmap.put(number, hashmap.get(number) + 1);
            } else {
                hashmap.put(number, 1);
            }
        }

        int majorityCount = arr.length / 3;

        for (Integer key : hashmap.keySet()) {
            if (hashmap.get(key) > majorityCount) {
                System.out.print(key + " ");
            }
        }
    }

    /*
     * Valid Anagram
     * given two strings s and t, return true if t is an anagram of s, and false
     * otherwise. An anagram is a word or phrase formed by rearranging the letters
     * of a different word or phrase, typically using all the original letters
     * exactly once
     * ex: s = "race", t = "care" TRUE
     * ex2: s = "heart" t = "earth" TRUE
     * ex3: s = "tulip", t = "lipid" FALSE
     * 
     * time complexity: O(n)
     * space complexity: O(n)
     */
    public static boolean isValidAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> hasmap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            if (hasmap.containsKey(character)) {
                hasmap.put(character, hasmap.get(character) + 1);
            } else {
                hasmap.put(character, 1);
            }
        }

        for (int j = 0; j < t.length(); j++) {
            char character = t.charAt(j);
            if (hasmap.get(character) != null) {
                if (hasmap.get(character) == 1) {
                    hasmap.remove(character);
                } else {
                    hasmap.put(character, hasmap.get(character) - 1);
                }
            } else {
                return false;
            }

        }

        return hasmap.isEmpty();
    }

    /*
     * Count distinct(unique) elements
     * ex: nums = {4, 3, 2, 5, 6, 7, 3, 4, 2, 1}
     * ans = 7
     * 
     * time complexity: O(n)
     * space complexity: O(n)
     */
    public static int countDistinctElements(int num[]) {
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < num.length; i++) {
            hashSet.add(num[i]);
        }

        return hashSet.size();
    }

    /*
     * Union and insertion of 2 arrays
     * ex:
     * arr1 = {7, 3, 9}
     * arr2 = {6, 3, 9, 2, 9, 4}
     * union = 6 (7, 3, 9, 6, 2, 4)
     * insertion = 2 (3, 9)
     * 
     * time complexity:
     * space complexity:
     */
    public static void unionIntertion(int arr1[], int arr2[]) {
        HashSet<Integer> hashSet = new HashSet<>();

        // union
        for (int i = 0; i < arr1.length; i++) {
            hashSet.add(arr1[i]);
        }

        for (int j = 0; j < arr2.length; j++) {
            hashSet.add(arr2[j]);
        }

        System.out.println("Union = " + hashSet.size());
        hashSet.clear();

        // insertion
        int insertion = 0;
        for (int i = 0; i < arr1.length; i++) {
            hashSet.add(arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            if (hashSet.contains(arr2[i])) {
                insertion++;
                hashSet.remove(arr2[i]);
            }
        }
        System.out.println("Insertion =  " + insertion);
    }

    /*
     * Find Itinerary from tickets
     * "Chennai" -> "Bengaluru"
     * "Mumbai" -> "Delhi"
     * "Goa" -> "Chennai"
     * "Delhi" -> "Goa"
     * ans: "Mumbai" -> "Delhi" -> "Goa" -> "Chennai" -> "Bengaluru"
     * 
     * time complexity: O(n)
     * space complexity: O(n)
     */

    public static void findItinerary(Map<String, String> tickets) {
        String start = startingPoint(tickets);
        System.out.print(start);
        for (String key : tickets.keySet()) {
            System.out.print("-> " + tickets.get(start));
            start = tickets.get(start);
        }
    }

    private static String startingPoint(Map<String, String> tickets) {
        HashMap<String, String> reverseMap = new HashMap<>();
        for (String key : tickets.keySet()) {
            reverseMap.put(tickets.get(key), key);
        }

        for (String key : tickets.keySet()) {
            if (!reverseMap.containsKey(key)) {
                return key;
            }
        }

        return null;
    }
}
