package interview.Microsoft.DSA1;

class add{
    int data;
    add next;

    public add(int data) {
        this.data = data;
        this.next = next;
    }
}

public class Add2Numbers {
    add head, ptr, idx, temp;

    public static void main(String[] args) {
        Add2Numbers list1 = new Add2Numbers();
        list1.head = new add(1);
        list1.head.next = new add(2);
        Add2Numbers list2 = new Add2Numbers();
        list2.head = new add(8);
        list2.head.next = new add(8);

        Add2Numbers list3 = new Add2Numbers();
        list3.head = add2List(list1.head, list2.head);
        display(list3.head);
    }

    private static void display(add a) {
        while (a != null) {
            System.out.print(a.data + " ");
            a = a.next;
        }
        System.out.println();
    }

    private static add add2List(add a, add b) {
        if (a == null) return b;
        if (b == null) return a;

        int c1 = count(a), c2 = count(b);
        if (c1 < c2) {
            add t = a;
            a = b;
            b = t;
        }

        a = reverse(a);
        b = reverse(b);
        add temp = a;
        int sum = 0, carry = 0;
        add ptr1 = null;

        while (a != null && b != null) {
            sum = a.data + b.data + carry;
            a.data = sum % 10;
            carry = sum / 10;
            a = a.next;
            b = b.next;
        }

        while (a != null) {
            sum = a.data + carry;
            a.data = sum % 10;
            carry = sum / 10;
            a = a.next;
        }
        if (carry > 0) {
            ptr1 = temp;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new add(carry);
        }
        if (ptr1 != null) {
            temp = ptr1;
        }
        return reverse(temp);
    }

    private static add reverse(add a) {
        add curr = a, next = null, prev = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static int count(add a) {
        int c = 0;
        while (a != null) {
            a = a.next;
            c++;
        }
        return c;
    }
}
