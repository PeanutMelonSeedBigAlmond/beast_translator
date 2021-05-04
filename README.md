# 兽语翻译器

*复刻自 南+ js*

使用范例

```kotlin
val beastString = toBeast("两只老虎爱跳舞，小兔子乖乖拔萝卜")
println(beastString)
val rawString = fromBeast(beastString)
println(rawString)
```

输出

```
~呜嗷呜嗷~~呜嗷呜~啊呜啊嗷呜嗷嗷呜嗷嗷啊呜啊啊~嗷呜嗷嗷~嗷啊~呜呜~嗷~呜呜呜嗷~嗷嗷啊呜呜啊啊嗷嗷啊~啊~啊呜啊~~嗷~啊啊~呜呜~呜嗷啊嗷啊啊呜呜啊啊~啊~~呜呜嗷~~啊~嗷嗷啊~嗷~呜呜呜嗷~~呜~啊呜啊啊呜~嗷~啊~嗷嗷~呜啊~啊嗷嗷呜嗷嗷嗷~啊~啊
两只老虎爱跳舞，小兔子乖乖拔萝卜
```

具体实现请查看[main.kt](src/main.kt)