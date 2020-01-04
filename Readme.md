<div align=center><p><font size="24"><b>Final Report</b></font></p></div>
---

<div align=center><p><font size="2">小组成员：唐麒 汤新宇</font></p></div>
---

你可以在以下地址观看项目视频

- 项目视频
http://47.94.107.165/app.mp4


- 测试视频
http://47.94.107.165/test.mp4

<div align=left><p><font size="4"><b>1、UI设计</b></font></p></div>
- Constraint layout

```xml
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.example.android_e_learning.LogoActivity">
```

- Relative layout

```xml
<RelativeLayout
    android:background="#ff2e75b6"
    android:layout_width="match_parent"
    android:layout_height="match_parent">
```

- Linear layout

```xml
<LinearLayout
    android:id="@+id/text_lin"
    android:layout_marginTop="45dp"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_centerHorizontal="true"
    android:orientation="vertical" >
```

- Swipe refresh layout

```xml
<LinearLayout
    android:id="@+id/text_lin"
    android:layout_marginTop="45dp"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_centerHorizontal="true"
    android:orientation="vertical" >
```

---

<div align=left><p><font size="4"><b>2、功能说明</b></font></p></div>
- 起始页面

<img src="http://static.zybuluo.com/TangWill/rvbcy9m80ihyjn348efaz19u/01.jpg" alt="01" style="zoom: 15%;" />

​		起始页面通过 animation 执行动画，向用户展示软件LOGO、名称和标语等宣传性信息。

- 新手导航

<div align="center"><img src="http://static.zybuluo.com/TangWill/g2zoi83kc44rwadj62difeeo/02.jpg" alt="02" style="zoom:15%;" />   <img src="http://static.zybuluo.com/TangWill/xwbq2a8i1ugokz2wv06qgwjx/03.jpg" alt="03" style="zoom:15%;" />    <img src="http://static.zybuluo.com/TangWill/t2ribz202d2e077r1uc9bd1c/04.jpg" alt="04" style="zoom:15%;" /></div>

​		新手导航通过 viewpager 实现三个页面之间的滑动切换，通过 sharepreference 实现单次下载新手导航页面只出现一次的功能，即除第一次进入软件进行展示外，之后该界面不再出现。

```xml
<androidx.viewpager.widget.ViewPager
    android:id="@+id/splash_vp"
    android:layout_width="match_parent"
    android:layout_height="match_parent" />
```

- 注册/登录界面

<div align="center"><img src="http://static.zybuluo.com/TangWill/nmvmh0n77h1hso9uon6wyxxx/05.jpg" alt="05" style="zoom:15%;" />                     <img src="http://static.zybuluo.com/TangWill/e28kp81j7y3apvf7rj6ipxr3/06.jpg" alt="06" style="zoom:15%;" /></div>                             

​		注册/登录界面通过 Linear layout 的反复嵌套和对其他组件的布局管理，实现以上展示的界面，并对用户输入的不合法信息进行检测，如必填数据为空、密码与确认密码不一致等。此外，仍旧通过 Shared preference 实现单次登陆且恢复上次退出界面。

- 第三方登录

<img src="http://static.zybuluo.com/TangWill/8s0gjk5ovqysn81h0dhcysh5/07.jpg" alt="07" style="zoom:15%;" />

​		该界面在通过腾讯开发者平台认证和项目申请后，通过腾讯提供的接口，实现第三方登录，获取的权限如下图所示：

<img src="C:%5CUsers%5Ctq%5CAppData%5CRoaming%5CTypora%5Ctypora-user-images%5Cimage-20200104101859651.png" alt="image-20200104101859651" style="zoom:50%;" />

```java
@Override
public void onQQLoginSuccess(JSONObject jsonObject, QQLogInManager.UserAuthInfo authInfo) {
    final SharedPreferences sharedPreferences = getSharedPreferences("is_first_in_data", MODE_PRIVATE);
    final MySharedPreferences mySharedPreferences = MySharedPreferences.getSharedPreferences(sharedPreferences);
    mySharedPreferences.setIsFirstLogInTwo();
    Intent intent = new Intent(MainActivity.this, ListCourseActivity.class);
    startActivity(intent);
    overridePendingTransition(R.anim.out_alpha, R.anim.enter_alpha);
    finish();
}
```

函数 onQQLoginSuccess：JSONObject 里QQ用户信息 json 格式

```json
{
  "open_id":当前登录QQ唯一标识,
  "access_token": accessToken,
  "expires_in": accessToken的有效时间,
  "nickname":昵称,
  "gender":性别,
  "province":所在省份,
  "city":所在城市,
  "year":出生年,
  "constellation":星座,
  "figureurl":30X30的头像URL,
  "figureurl_1":50X50的头像URL,
  "figureurl_2":100X100的头像URL,
  "figureurl_qq_1":40X40的头像URL,
  "figureurl_qq_2":100X100的头像URL,
  "vip":是否为qq会员,
  "level":qq会员等级,
  "is_yellow_vip":是否为黄钻,
  "yellow_vip_level":黄钻等级,
  "is_yellow_year_vip":是否为黄钻年会员
}
```

- 课程列表

<div align="center"><img src="http://static.zybuluo.com/TangWill/31pvseprw81o1uediw8e2c47/08.jpg" alt="08" style="zoom:15%;" />   <img src="http://static.zybuluo.com/TangWill/kg6vm25yphq9e301fxidy13e/09.jpg" alt="09" style="zoom:15%;" />    <img src="http://static.zybuluo.com/TangWill/uzg560uwsi5mubj8qm3wv63b/10.jpg" alt="10" style="zoom:15%;" /></div>

​		课程列表通过 Swipe refresh layout 和 RecycleView 的嵌套，包括定义两种类型的 item 布局，实现课程列表的动态加载和多元化展示，通过监听服务器数据推送和 Notification 实现信息提示和下拉刷新更新数据。

	- MVVM

​		在该界面和其他模块使用数据绑定和 MVVM 开发模式，部分代码如下所示。

```xml
<data>
    <variable
        name="homeviewmodel"
        type="com.example.android_e_learning.ui.home.HomeViewModel" />
</data>

  <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="vertical">

            <TextView
                android:id="@+id/coursename"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_gravity="left"
                android:padding="15dp"
                android:text="@{homeviewmodel.course.name}"
                android:textColor="#000000"
                android:textSize="30sp" />

            <TextView
                android:id="@+id/introduction"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_gravity="left"
                android:padding="5dp"
                android:text="@string/introduction"
                android:textColor="#000000"
                android:textSize="24sp" />

            <TextView
                android:id="@+id/description"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_gravity="center"
                android:padding="10dp"
                android:text="@{homeviewmodel.course.description}"
                android:textColor="#8B000000"
                android:textSize="18sp" />
```

```java
public class HomeViewModel extends BaseObservable {
    private Course course;
    private Teacher teacher;

    public HomeViewModel(Course course) {
        this.course = course;
        this.teacher = course.getArrayList().get(0);
    }

    @Bindable
    public Course getCourse() {
        return course;
    }

    @Bindable
    public void setCourse(Course course) {
        this.course = course;
        notifyChange();
    }

    @Bindable
    public Teacher getTeacher() {
        return teacher;
    }

    @Bindable
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
        notifyChange();
    }
}
```

- 课程详情

<div align="center"><img src="http://static.zybuluo.com/TangWill/t9oz03gfbxjaz472j06pc9yq/11.jpg" alt="11" style="zoom:15%;" />   <img src="http://static.zybuluo.com/TangWill/no5z1yfubfvj4o4cem83ikyn/12.jpg" alt="12" style="zoom:15%;" /></div>                            

​		课程详情通过对 ActionBar 进行操作，添加退出和分享的功能，可进行微信、QQ等分享，并通过 Linear layout 对页面进行布局管理。

- 导航栏

<div align="center"><img src="http://static.zybuluo.com/TangWill/1ehnjnt2ifwbne3z4rnmtrht/13.jpg" alt="14" style="zoom:15%;" />   <img src="http://static.zybuluo.com/TangWill/k6vyp1h3dbic2733bnc6v0yc/14.jpg" alt="13" style="zoom:15%;" /></div>                                                                    

​		通过 Navigation 进行导航，除了之前的 HomeFragement，主要实现了含有 WebView 的官网介绍和分享下载二维码的界面。
