# Reverse Regexp
![](https://img.shields.io/github/languages/top/github-laziji/reverse-regexp.svg?style=flat)
![](https://img.shields.io/github/stars/gitHub-laziji/reverse-regexp.svg?style=social)

从正则表达式生成随机数据

## 安装

```pom.xml
<dependency>
    <groupId>com.github.kancyframework</groupId>
    <artifactId>reverse-regexp</artifactId>
    <version>1.0.4</version>
</dependency>
```

## 使用
### 随机字符语法
支持大部分正则表达式的匹配语法
- `\d` 数字, 相当于`[0-9]`
- `\w` 数字、字母加下划线, 相当于`[0-9a-zA-Z_]`
- `\s` 空白字符, 只包含空格和制表符
- `.` 除`\n`和`\r`以外的任意字符, 生成随机字符时只在`ascii`码`0~255`之间生成
- `[a-zA-Z甲乙]` 区间, 不支持`^`语法
- 以及其他字符
### 重复打印语法
与正则表达式的重复匹配语法相同
- `?` 随机生成0个或1个字符
- `*` 随机生成0个以上字符, 默认最多16个
- `+` 随机生成1个以上字符, 默认最多16个
- `{n}` 生成n个字符
- `{n,}` 随机生成n~个字符, 默认最多`max(16,n)`个
- `{n,m}` 随机生成n~m个字符

### 其他语法
- `|` 或语法, 例如`aaa|bbb|ccc`随机生成`aaa`或`bbb`或`ccc`, 概率相等
- `()` 支持括号

### 常用正则
- 邮箱 `\w{6,12}@[a-z0-9]{3}\.(com|cn)`
- 手机号 `1(3|5|7|8)\d{9}`
- 电话 `\d{3}-\d{8}|\d{4}-\d{7}`
- 英文名 `[A-Z][a-z]{4,6}`
- 年龄 `[1-9][0-9]?`
- 网址 `https?://[\w-]+(\.[\w-]+){1,2}(/[\w-]{3,6}){0,2}(\?[\w_]{4,6}=[\w_]{4,6}(&[\w_]{4,6}=[\w_]{4,6}){0,2})?`
- IPv4 `(\d|[1-9]\d|1\d{2}|2[0-4]\d|25[0-5])(\.(\d|[1-9]\d|1\d{2}|2[0-4]\d|25[0-5])){3}`

```java
public class RegexpRandomTest {

    @Test
    public void test1() {
        RegexpRandom random = new RegexpRandom("1(3|5|7|8)\\d{9}");
        System.out.println(random.next());
        System.out.println(random.nextBatch(10));
        System.out.println(random.next("1(3|5|7|8)\\d{9}"));
        System.out.println(random.next("^1(3|5|7|8)\\d{9}$"));
        System.out.println(random.nextBatch("^1(3|5|7|8)\\d{9}$", 10));
    }

    @Test
    public void test2() {
        RegexpRandom random = new RegexpRandom();
        System.out.println(random.next("1(3|5|7|8)\\d{9}"));
        System.out.println(random.next("^1(3|5|7|8)\\d{9}$"));
        System.out.println(random.nextBatch("^1(3|5|7|8)\\d{9}$", 10));
    }

    @Test
    public void test3() {
        System.out.println(RandomUtils.next("1(3|5|7|8)\\d{9}"));
        System.out.println(RandomUtils.next("^1(3|5|7|8)\\d{9}$"));
        System.out.println(RandomUtils.nextBatch("^1(3|5|7|8)\\d{9}$", 10));
    }

    @Test
    public void test4() {
        System.out.println(RandomUtils.nextEmail(5));
        System.out.println(RandomUtils.nextZipCode(5));
        System.out.println(RandomUtils.nextIdCardNo(5));
        System.out.println(RandomUtils.nextBankCardNo(5));
        System.out.println(RandomUtils.nextBankDebitCardNo(5));
        System.out.println(RandomUtils.nextIp(5));
        System.out.println(RandomUtils.nextMobile(5));
        System.out.println(RandomUtils.nextHttp(5));
    }
}
```

输出
```
test4输出结果
[OQHUK74uCWy@i70.cn, UNJYAujF4@ogm.com, ATZJiup5b@wef.cn, 8QZLHiW@v0a.cn, T7arCnIe@vvb.cn]
[801007, 570908, 839760, 543514, 448636]
[17669020971230080X, 865139200408301590, 790410199210303966, 968037193504062104, 52149019041010875X]
[56007280863390654, 1930072410374849374, 1992202066069717681, 5452236171842539, 5698423870114227]
[8981342767913740800, 3315844703763428, 2372181803002087099, 74131898472300983, 4042192305470382]
[114.255.07.2, 9.01.15.9, 250.031.206.91, 232.35.250.100, 216.4.3.237]
[14981654113, 16667744602, 18450954702, 17797631558, 17480313728]
[http://QHlREH.xZtZTv2ZYTP.hsyqxY/0qblR/rYQj?MmLhq=rUhULb&yDwRJZ=9QFx5&OD6o=eDgz, http://cVYS.5gbd/DW7Mr?HPYmm=uESN92&U1bcd=QeRlP&Qg6AM0=Logr, https://Xk.ip05.nmeDdu?FAVXi=TBQWsr&uuBF=6oJKY&kOQi=rHFlf, https://xDlaT5gi6wI1O2yf.maP4F-zn0rJkXfl.C/uQme?KOhuyy=IMgivS&7bLF=OyIf&LOGG=ElH6R, http://lQo4xmP1W.7LRMXPofzqu/GOx_?oL4Ht=WnxXjC&58EnU=RMPCF&68Am=djlRfl]
```