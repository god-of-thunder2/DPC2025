import java.util.Scanner;

public class day4 {
    public static void swap(int i, int arr1[], int j, int arr2[]) {
        if (arr1[i] > arr2[j]) {
            int temp = arr1[i];
            arr1[i] = arr2[j];
            arr2[j] = temp;
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = (m + n);
        int gap = (len / 2) + (len % 2); // take sealing of (m+n)/2
        while (gap > 0) {
            int i = 0;
            int j = i + gap;
            while (j < len) {
                // i in nums1 and j in nums2
                if (i < m && j >= m) {
                    swap(i, nums1, j - m, nums2);
                }
                // i in nums2 and j in nums2
                else if (i >= m) {
                    swap(i - m, nums2, j - m, nums2);
                }
                // i in nums1 and j in nums1
                else {
                    swap(i, nums1, j, nums1);
                }
                i++;
                j++;
            }

            if (gap == 1) {
                break;
            }
            gap = (gap / 2) + (gap % 2);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("enter m-");
        int m = sc.nextInt();
        int[] nums1 = new int[m];
        System.out.println("enter " + m + "elems in array 1 in sorted order");
        for (int i = 0; i < m; i++) {
            nums1[i] = sc.nextInt();
        }

        System.out.print("enter n-");
        int n = sc.nextInt();
        int[] nums2 = new int[n];
        System.out.println("enter " + n + "elems in array 2 in sorted order");
        for (int i = 0; i < n; i++) {
            nums2[i] = sc.nextInt();
        }

        System.out.println("\nbefore merging-");
        for (int i : nums1)
            System.out.print(i + " ");
        for (int i : nums2)
            System.out.print(i + " ");
        System.out.println();

        merge(nums1, m, nums2, n);

        System.out.println("\nafter merging-");
        for (int i : nums1)
            System.out.print(i + " ");
        for (int i : nums2)
            System.out.print(i + " ");

        sc.close();
    }
}
