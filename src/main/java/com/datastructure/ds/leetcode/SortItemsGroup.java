package com.datastructure.ds.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author : tianyu.wang
 * create at:  2021/6/10  上午11:39
 * @description: 项目管理
 * 拓扑排序
 * 1. 如何得到组 group 的先后关系
 * 如果不考虑「同一小组的项目，排序后在列表中彼此相邻」。根据 beforeItems 可以得到项目 item 的拓扑排序结果；
 * 由数组 group 可以得到项目 item 对应的组的编号。
 * 由以上两点，可以得到 组 group 的先后关系。
 * 表格第 2 行（不计算表头）：项目 6 （组号 0）必需在项目 1 （不属于任何组，暂时记组号为 2）的前面，可以得出：组号为 0 的所有项目应该位于组号为 2 的所有项目的前面。
 * <p>
 * 有可能出现这种情况：前驱项目和当前项目分在一组，这样的数据需要舍弃，例如第 5 行。项目 3 、项目 6 必需被安排在项目 4 的前面，但是它们的组号都为 0。
 * <p>
 * 2. 如何让相同组号的项目在一起
 * 由上一步的结果得到「组的先后关系」，进而得到组 group 的拓扑排序结果。而 同组的项目也必须满足先后顺序，因此必需对项目 item 也执行一次拓扑排序。
 * <p>
 * 按照项目 item 的拓扑排序结果，依次 把它们映射到对应的组 group 里，这一步需要建立一个映射关系：key 是组编号，value 是同一组的项目按照拓扑排序的结果。
 * <p>
 * 再根据组 group 的拓扑排序的结果，以及上一步建立的映射关系，把 group 映射到 item 列表，就得到了题目要求的 ① 同组项目放在一起 ② 且项目之间还满足拓扑序的拓扑排序结果。
 * <p>
 * 3. 细节：为什么须要给 group[i] = -1 的项目赋值为一个新的组号？
 * 根据题意，group[i] = -1 表示编号为 i 的项目，不属于编号为 0 到 m - 1 的这 m 个组，换句话说，完成这些项目不需要协同合作。
 * <p>
 * 又因为我们需要根据「组」的先后顺序得到「组的拓扑排序的结果」。为了避免我们设计的算法认为 group[i] = -1 的这些项目都在同一组，因此给 group[i] = -1 的这些组一个不同于 0 到 m - 1 的编号，从 m 开始逐个给每个项目编号即可。
 * 复杂度分析：
 * <p>
 * 说明：这里为了表达严谨，时间复杂度和空间复杂度的描述比较理论化。大家未必须要深究。就当前这个问题而言，拓扑排序就是就是在图中进行一次广度优先遍历，时间复杂度为图的顶点数加边数，假设当前问题的图结构的顶点数为 VV、边数为 EE，可以简记时间复杂度为 O(V + E)O(V+E)。
 * <p>
 * 时间复杂度：O(m + n^2 + E_{group} + E_{item} )O(m+n
 * 2
 * +E
 * group
 * ​
 * +E
 * item
 * ​
 * )，这里 nn 是项目的总数，mm 是组的总数（把标记为 -1−1 的组预处理以后，新的组的总数不会超过 2m2m）；
 * <p>
 * 对组的数据进行预处理 O(m)O(m)；
 * 构建组的邻接表 O(m)O(m)、项目的邻接表 O(n^2)O(n
 * 2
 * )，遍历 before，最极端情况下，第 11 个顶点指向所有剩余 n - 1n−1 个顶点，第 22 个顶点指向所有剩余 n - 2n−2 个顶点，……；
 * 构建组的入度数组 O(m)O(m)、项目入度数组 O(n)O(n)；
 * 执行组的拓扑排序O(m + E_{group})O(m+E
 * group
 * ​
 * )、项目的拓扑排序 O(n + E_{item})O(n+E
 * item
 * ​
 * )。这里用 E_{group}E
 * group
 * ​
 * 表示组的邻接表的边数， E_{item}E
 * item
 * ​
 * 表示项目的邻接表的边数；
 * 构建组到项目的一对多关系 O(m + n)O(m+n)；
 * 输出符合题目要求的结果 O(m + n)O(m+n)。
 * 空间复杂度：O(m + n^2)O(m+n
 * 2
 * )；
 * <p>
 * 组的邻接表 O(m)O(m)、项目的邻接表 O(n^2)O(n
 * 2
 * )；
 * 组的入度数组 O(m)O(m)、项目入度数组 O(n)O(n)；
 * 组到项目的一对多关系 O(m + n)O(m+n)；
 * 符合题目要求的结果 O(m + n)O(m+n)。
 */
public class SortItemsGroup {

    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        List<List<Integer>> groupItem = new ArrayList<>();//项目分组
        for(int i = 0;i < n + m;i++){//初始化小组
            groupItem.add(new ArrayList<>());
        }
        int gId = m;//新的组号从m开始
        for(int i = 0;i < group.length;i++){
            if(group[i] == -1)group[i] = gId++;//没有id的加上组id
            groupItem.get(group[i]).add(i);//同一组的放在一起
        }
        List<List<Integer>> graphInGroup = new ArrayList<>();//组内拓扑关系
        List<List<Integer>> graphOutGroup = new ArrayList<>();//组间拓扑关系
        for(int i = 0;i < n + m;i++){//初始化拓扑关系
            graphOutGroup.add(new ArrayList<>());
            if(i >= n)continue;
            graphInGroup.add(new ArrayList<>());
        }
        List<Integer> groupId = new ArrayList<>();//所有组id
        for(int i = 0;i < n + m;i++){
            groupId.add(i);
        }
        // 需要拓扑排序 所以结点的入度必不可少 两个数组分别维护不同结点的入度
        int[] degInGroup = new int[n];//组内 结点入度 （组内项目入度）
        int[] degOutGroup = new int[n + m];//组间 结点入度（小组入度）

        for(int i = 0;i < beforeItems.size();i++){//遍历关系
            int curGroupId = group[i];//当前项目i所属的小组id
            List<Integer> beforeItem = beforeItems.get(i);
            for(Integer item : beforeItem){
                if(group[item] == curGroupId){//同一组 修改组内拓扑
                    degInGroup[i]++;// 组内结点的入度+1
                    graphInGroup.get(item).add(i);//item 在 i之前
                }else{
                    degOutGroup[curGroupId]++;// 小组间的结点入度 + 1
                    graphOutGroup.get(group[item]).add(curGroupId);// group[item] 小组 在 curGroupId 之前
                }
            }
        }
        //组间拓扑排序，也就是小组之间的拓扑排序，需要的参数 小组结点的入度degOutGroup，所有的小组groupId，组间的拓扑关系图graphOutGroup
        List<Integer> outGroupTopSort = topSort(degOutGroup,groupId,graphOutGroup);
        if(outGroupTopSort.size() == 0)return new int[0];//无法拓扑排序 返回

        int[] res = new int[n];
        int index = 0;
        for(Integer gid : outGroupTopSort){//遍历排序后的小组id
            List<Integer> items = groupItem.get(gid);//根据小组id 拿到这一小组中的所有成员
            if(items.size() == 0)continue;
            //组内拓扑排序，需要的参数 组内结点的入度degInGroup，组内的所有的结点groupItem.get(gid)，组内的拓扑关系图graphInGroup
            List<Integer> inGourpTopSort = topSort(degInGroup,groupItem.get(gid),graphInGroup);
            if(inGourpTopSort.size() == 0)return new int[0];//无法拓扑排序 返回
            for(int item : inGourpTopSort){//排序后，依次的放入答案集合当中
                res[index++] = item;
            }
        }
        return res;
    }

    public List<Integer> topSort(int[] deg, List<Integer> items,List<List<Integer>> graph){
        Queue<Integer> queue = new LinkedList<>();
        for(Integer item:items){
            if(deg[item] == 0)queue.offer(item);
        }
        List<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()){
            int cur = queue.poll();
            res.add(cur);
            for(int neighbor: graph.get(cur)){
                if(--deg[neighbor] == 0){
                    queue.offer(neighbor);
                }
            }
        }
        return res.size() == items.size() ? res : new ArrayList<>();
    }






}
