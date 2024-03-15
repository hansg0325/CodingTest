import java.io.*;
import java.util.*;

public class Main {
    static int root;
    static Node[] tree;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        tree = new Node[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            tree[i] = new Node(parent); // 노드의 번호는 i, i번 노드의 부모는 parent 인 Node를 생성
            if (parent == -1) { // parent 번호가 -1 이면 해당 노드는 루트 노드
                root = i;
            }
        }

        // 루트 노드가 아닌 경우, 해당 노드의 부모 노드를 찾아 자식노드에 자신을 추가
        for (int i = 0; i < N; i++) {
            if (root != i) { // 루트노드가 아닐경우
                int parent = tree[i].parent; // i 번 노드의 부모노드를 꺼내서
                tree[parent].addChild(i); // 부모노드의 자식에 i번 노드를 추가해줌
            }
        }

        int removeNode = Integer.parseInt(br.readLine()); // 삭제 할 노드 번호
        if (removeNode == root) { // 루트 노드를 지울경우 전부 삭제되므로 0 출력
            System.out.println(0);
        } else {
            int parent = tree[removeNode].parent; // 삭제하려는 노드의 부모 노드의 값을 꺼냄
            tree[parent].removeChild(removeNode); // 그 부모노드의 자식노드들 중 삭제하려는 노드번호를 삭제
            int leafSize = getLeafSize(root); // 리프노드의 수를 카운팅
            System.out.println(leafSize);
        }
    }

    static int getLeafSize(int index) {
        if (tree[index].isLeaf()) { // 해당 노드의 자식노드가 없다면 true 를 반환해서
            return 1; // 1 반환
        }
        int sum = 0;
        for (int i = 0; i < tree[index].getChildrenSize(); i++) {
            sum += getLeafSize(tree[index].children.get(i)); // 반복문을 재귀적으로 돌며 자식노드가 없는 노드들을 탐색
        }
        return sum;
    }
}

// 노드 클래스
class Node {
    int parent; // 해당 노드의 부모 노드
    List<Integer> children; // 자식노드들

    public Node(int parent) {
        this.parent = parent;
        this.children = new ArrayList<>(); // 자식노드들은 ArrayList 로 생성
    }

    public void addChild(int child) { // 노드의 자식들을 ArrayList.add 로 삽입
        this.children.add(child);
    }

    public void removeChild(int child) { // 노드의 자식들을 ArrayList.remove 로 삭제
        this.children.remove(Integer.valueOf(child));
    }

    public boolean isLeaf() { // 노드의 자식이 없다면 true 반환
        return this.children.isEmpty();
    }

    public int getChildrenSize() { // 노드의 자식들의 개수를 ArrayList.size() 메서드를 활용해 출력
        return this.children.size();
    }
}