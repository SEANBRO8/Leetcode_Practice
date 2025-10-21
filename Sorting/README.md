## ✅ 总结口诀# 🧮 Sorting Algorithms — Complexity & LeetCode Applications

---

## 📊 核心复杂度对比表

| 算法 | 平均时间复杂度 | 最坏时间复杂度 | 空间复杂度 | 稳定性 | 适用场景 / 思维模式 |
|:--|:--:|:--:|:--:|:--:|:--|
| **Bubble Sort** | O(n²) | O(n²) | O(1) | ✅ | 教学演示，不用于实战 |
| **Insertion Sort** | O(n²) | O(n²) | O(1) | ✅ | 小规模数组 / 部分有序 |
| **Selection Sort** | O(n²) | O(n²) | O(1) | ❌ | 教学算法，不实用 |
| **Merge Sort** | O(n log n) | O(n log n) | O(n) | ✅ | 链表排序 / 大数据 / 稳定性要求 |
| **Quick Sort** | O(n log n) | O(n²) | O(log n) | ❌ | 大部分数组排序题，通用首选 |
| **Heap Sort** | O(n log n) | O(n log n) | O(1) | ❌ | Top K / Kth Largest / 优先队列类问题 |
| **Counting Sort** | O(n + k) | O(n + k) | O(k) | ✅ | 整数范围小，如颜色分类/年龄统计 |
| **Bucket Sort** | O(n + k) | O(n²) | O(n + k) | ✅ | 实数/均匀分布，如分数、浮点数排序 |
| **Radix Sort** | O(d·(n + k)) | O(d·(n + k)) | O(n + k) | ✅ | 固定位数整数/字符串排序 |
| **TimSort** | O(n log n) | O(n log n) | O(n) | ✅ | 默认排序算法（Java/Python 内置） |

---

## 🧠 面试中「如何选择」

| 需求 / 场景 | 选用算法 | 解释 |
|:--|:--|:--|
| 普通数组排序（int/double） | **Quick Sort** | 平均最快，原地排序 |
| 需要稳定性（对象/链表） | **Merge Sort / TimSort** | 稳定，不受数据分布影响 |
| 数据几乎有序 | **Insertion Sort** | 小规模 / 局部有序极快 |
| 数据范围小的整数 | **Counting Sort** | 线性时间，适用于小范围离散值 |
| 实数且分布均匀 | **Bucket Sort** | 期望 O(n)，分桶后局部排序 |
| 固定位数整数/字符串 | **Radix Sort** | O(d·(n+k))，适合定长数 |
| 求前 K / 第 K 大元素 | **Heap Sort / PriorityQueue** | Top K 问题首选 |
| 链表排序 | **Merge Sort (链表版)** | 可 O(1) 空间稳定排序 |

---

## 🧩 LeetCode 高频题按排序思想分类

| 算法思想 | 代表题目 | 题号 | 难度 | 核心思维 |
|:--|:--|:--|:--:|:--|
| **Insertion Sort** | [Insertion Sort List](https://leetcode.com/problems/insertion-sort-list/) | 147 | 🟠 Medium | 链表版插排，节点插入 |
| **Merge Sort** | [Sort List](https://leetcode.com/problems/sort-list/) | 148 | 🟠 Medium | 链表归并排序（稳定） |
| **Quick Sort / Partition** | [Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array/) | 215 | 🟠 Medium | Quickselect，平均 O(n) |
| | [Sort Colors](https://leetcode.com/problems/sort-colors/) | 75 | 🟢 Easy | 0/1/2 分类问题（Counting） |
| | [Wiggle Sort II](https://leetcode.com/problems/wiggle-sort-ii/) | 324 | 🔴 Hard | 分区 + 局部重排 |
| **Heap Sort (Top K)** | [Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/) | 347 | 🟠 Medium | 小顶堆维持前 K 个 |
| | [Kth Largest in Stream](https://leetcode.com/problems/kth-largest-element-in-a-stream/) | 703 | 🟢 Easy | PriorityQueue 维护堆 |
| **Counting Sort** | [Sort Characters by Frequency](https://leetcode.com/problems/sort-characters-by-frequency/) | 451 | 🟠 Medium | 计数统计 + 桶排输出 |
| | [Relative Sort Array](https://leetcode.com/problems/relative-sort-array/) | 1122 | 🟢 Easy | 计数排序实现相对顺序 |
| **Bucket Sort** | [Maximum Gap](https://leetcode.com/problems/maximum-gap/) | 164 | 🔴 Hard | 桶内最小最大值差距 O(n) |
| | [Top K Frequent Words](https://leetcode.com/problems/top-k-frequent-words/) | 692 | 🟠 Medium | 桶 + 堆组合 |
| **Radix Sort** | [Maximum Gap (Alternative)](https://leetcode.com/problems/maximum-gap/) | 164 | 🔴 Hard | 基数排序优化整数 |
| **TimSort / 默认排序** | [Merge Intervals](https://leetcode.com/problems/merge-intervals/) | 56 | 🟠 Medium | 内置排序后线性合并 |
| | [Meeting Rooms II](https://leetcode.com/problems/meeting-rooms-ii/) | 253 | 🟠 Medium | 排序 + 最小堆 |

---

## 📘 复杂度 vs 题型总结表

| 复杂度级别 | 常用算法 | LeetCode 常见题型 |
|:--|:--|:--|
| **O(n log n)** | Merge, Quick, Heap | 排序链表、Kth Largest、Intervals、Top-K |
| **O(n + k)** | Counting, Bucket, Radix | Sort Colors, Frequency Sort, Maximum Gap |
| **O(n²)** | Insertion, Bubble | Insertion Sort List（链表），教学用 |
| **O(log n)** | 二分查找（排序后使用） | Binary Search, Search Range, Find Peak |
| **O(n)** | 特殊结构 + Counting/Bucket | Dutch Flag, Relative Sort Array |

---

## 🎯 面试策略建议

1. **排序复杂度背熟公式**  
   - 只要有比较操作的排序：下界 O(n log n)  
   - 线性时间排序（Counting/Bucket/Radix）依赖“非比较模型”  

2. **识别题目意图：**
   - 若题目要求 **第 K 大 / 前 K 大** → 用 **Heap / Quickselect**
   - 若题目要求 **统计频率 / 排序字符串** → **Counting Sort**
   - 若题目要求 **链表排序 / 稳定性** → **Merge Sort**
   - 若题目已部分有序 → **Insertion / TimSort 内置排序**

3. **能手写的：**
   - QuickSort（分区模板）
   - MergeSort（数组/链表）
   - CountingSort（支持负数版本）
   - Heap 排序逻辑（堆化 + 下沉）

---

## ✅ 总结口诀

快排快但不稳定，
归并稳却占空间；
堆排适合Top-K题，
计数桶基数线性牛；
链表归并是标配，
内置TimSort智能快；
整数离散看Counting，
浮点均匀用Bucket。
