class Solution {

    int[] parent, depth, size, heavy, head, pos;
    int timer;
    SegmentTree seg;

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {

        List<Integer>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        parent = new int[n];
        depth = new int[n];
        size = new int[n];
        heavy = new int[n];
        head = new int[n];
        pos = new int[n];

        Arrays.fill(parent, -1);
        Arrays.fill(heavy, -1);

        // Step 1: Find parent and depth
        int[] order = new int[n];
        int idx = 0;

        order[idx++] = 0;
        parent[0] = 0;

        for (int i = 0; i < idx; i++) {
            int u = order[i];

            for (int v : adj[u]) {
                if (v == parent[u]) {
                    continue;
                }

                parent[v] = u;
                depth[v] = depth[u] + 1;
                order[idx++] = v;
            }
        }

        // Step 2: Calculate subtree sizes and heavy child
        for (int i = n - 1; i >= 0; i--) {
            int u = order[i];
            size[u] = 1;

            int maxSize = 0;

            for (int v : adj[u]) {
                if (parent[v] == u) {
                    size[u] += size[v];

                    if (size[v] > maxSize) {
                        maxSize = size[v];
                        heavy[u] = v;
                    }
                }
            }
        }

        // Step 3: Heavy-Light Decomposition
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{0, 0});

        timer = 0;

        while (!stack.isEmpty()) {
            int[] item = stack.pop();
            int start = item[0];
            int chainHead = item[1];

            for (int u = start; u != -1; u = heavy[u]) {
                head[u] = chainHead;
                pos[u] = timer++;

                for (int v : adj[u]) {
                    if (parent[v] == u && v != heavy[u]) {
                        stack.push(new int[]{v, v});
                    }
                }
            }
        }

        // Step 4: Build Segment Tree
        int[] values = new int[n];
        char[] chars = s.toCharArray();

        for (int i = 0; i < n; i++) {
            values[pos[i]] = 1 << (chars[i] - 'a');
        }

        seg = new SegmentTree(values, n);

        // Step 5: Process queries
        List<Boolean> answer = new ArrayList<>();

        for (String q : queries) {
            String[] parts = q.split("\\s+");

            if (parts[0].equals("update")) {

                int u = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);

                chars[u] = c;

                seg.update(pos[u], 1 << (c - 'a'));

            } else {

                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);

                int mask = 0;

                while (head[u] != head[v]) {

                    if (depth[head[u]] < depth[head[v]]) {
                        int temp = u;
                        u = v;
                        v = temp;
                    }

                    mask ^= seg.query(pos[head[u]], pos[u]);

                    u = parent[head[u]];
                }

                int left = Math.min(pos[u], pos[v]);
                int right = Math.max(pos[u], pos[v]);

                mask ^= seg.query(left, right);

                answer.add(Integer.bitCount(mask) <= 1);
            }
        }

        return answer;
    }

    // Segment Tree
    class SegmentTree {

        int[] tree;
        int n;

        SegmentTree(int[] arr, int n) {
            this.n = n;
            tree = new int[4 * n];

            build(1, 0, n - 1, arr);
        }

        void build(int node, int start, int end, int[] arr) {

            if (start == end) {
                tree[node] = arr[start];
                return;
            }

            int mid = (start + end) / 2;

            build(node * 2, start, mid, arr);
            build(node * 2 + 1, mid + 1, end, arr);

            tree[node] = tree[node * 2] ^ tree[node * 2 + 1];
        }

        void update(int index, int value) {
            update(1, 0, n - 1, index, value);
        }

        void update(int node, int start, int end, int index, int value) {

            if (start == end) {
                tree[node] = value;
                return;
            }

            int mid = (start + end) / 2;

            if (index <= mid) {
                update(node * 2, start, mid, index, value);
            } else {
                update(node * 2 + 1, mid + 1, end, index, value);
            }

            tree[node] = tree[node * 2] ^ tree[node * 2 + 1];
        }

        int query(int left, int right) {
            return query(1, 0, n - 1, left, right);
        }

        int query(int node, int start, int end, int left, int right) {

            if (right < start || end < left) {
                return 0;
            }

            if (left <= start && end <= right) {
                return tree[node];
            }

            int mid = (start + end) / 2;

            int a = query(node * 2, start, mid, left, right);
            int b = query(node * 2 + 1, mid + 1, end, left, right);

            return a ^ b;
        }
    }
}