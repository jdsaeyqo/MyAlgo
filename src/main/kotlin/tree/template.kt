//package tree
//
//
//val parent = IntArray(3)
////트리 dfs
//fun dfs(cur : Int, pre : Int){
//
//    parent[cur] = pre
//    for(next in v[cur]){
//        if(next == pre){
//            continue
//        }
//        dfs(next,cur)
//
//    }
//}
//
//// 이진트리 순회 boj1991
//fun dfsOrder(cur : Char, option : Int){
//
//    if(cur == '.'){
//        return
//    }
//
//    if (option == 0){
//        println(cur)
//    }
//    dfsOrder(left[cur],option)
//    if (option == 1){
//        println(cur)
//    }
//    dfsOrder(right[cur],option)
//    if (option == 2){
//        println(cur)
//    }
//}
//
//
///**
// * boj 2263
// preOrder + inOrder
//
// postOrder + inOrder
//
// 둘 중 하나를 주면 트리 복구 가능
// **/
//
//
////트리 dfs
//fun dfsSize(cur : Int, pre : Int){
//    sz[cur] = 1
//
//    for(next in v[cur]){
//        if(next == pre){
//            continue
//        }
//        depth[next] = depth[cur] + 1
//        dfsSize(next,cur)
//
//        sz[cur] = sz[next]
//        parent[next] = cur
//
//    }
//
//}
//
//
//
