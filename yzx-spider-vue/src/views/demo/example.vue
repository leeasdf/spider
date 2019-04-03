<template>
    <div class="demo">
        <h3>vue</h3>
        <div>
            <p>表单输入绑定：v-model</p>
            <p>
                <div>事件绑定：v-on:事件 </div>
                <xmp>
                    <div>eg: &lt;button v-on:click="clickHandle"&gt;&lt;/button&gt;     <button v-on:click="clickHandle">测试</button></div>
                    <div>缩写方式：&lt;button @click="clickHandle"&gt;&lt;/button&gt;    <button @click="clickHandle">测试</button></div>
                </xmp>
            </p>
            <p>条件渲染：v-if v-else</p>
            <p>
                列表渲染：v-for
                <pre>
                    <div>eg:
                            &lt;ul id="example-1"&gt;
                                &lt;li v-for="item in items"&gt;

                                &lt;/li&gt;
                            &lt;/ul&gt;
                    </div>
                </pre>
            </p>
        </div>
        <h3>element UI</h3>
        <div>
            elment UI 框架组件由el- 方式命名
            eg: el-input, el-select, el-button
            <p>禁用：添加disabled 属性</p>
        </div>
        <h3>增删改查</h3>
        <h4>1.表单常用组件，验证相关见views/modules/spider/rpttnbasicinfo-add-or-update.vue</h4>
            <p>
                表单组件：el-form, el-form-item
            </p>
            <p>
                &lt;el-input v-model="enterpriseName" placeholder="输入框"&gt;&lt;/el-input&gt;
                <el-input v-model="enterpriseName" placeholder="输入框"></el-input>
            </p>
            <p>
                通过设置type 属性添加文本域
                &lt;el-input type="textarea" v-model="enterpriseName" placeholder="文本域"&gt;&lt;/el-input&gt;
                <el-input type="textarea" v-model="enterpriseName" placeholder="文本域"></el-input>
            </p>
            <p>
                下拉框：{{status}}<br>
                <el-select v-model="status">
                    <el-option label="选项一" value="A"></el-option>
                    <el-option label="选项二" value="B"></el-option>
                </el-select>
                <pre>
                    &lt;el-select v-model="status"&gt;
                        &lt;el-option label="选项一" value="A"&gt;&lt;/el-option&gt;
                        &lt;el-option label="选项二" value="B"&gt;&lt;/el-option&gt;
                    &lt;/el-select&gt;
                </pre>
            </p>
            <p>
                单选：{{radio1}}<br>
                <template>
                    <el-radio v-model="radio1" :label="1">是</el-radio>
                    <el-radio v-model="radio1" :label="0">否</el-radio>
                </template>
                <pre>
                    &lt;el-radio v-model="radio1" :label="1"&gt;是&lt;/el-radio&gt;
                    &lt;el-radio v-model="radio1" :label="0"&gt;否&lt;/el-radio&gt;
                </pre>
            </p>
            <p>
                复选：{{checkbox1}}
                <br>
                <template>
                    <el-checkbox v-model="checkbox1" label="A">AAA</el-checkbox>
                    <el-checkbox v-model="checkbox1" label="B">BBB</el-checkbox>
                </template>
                <pre>
                    &lt;el-checkbox v-model="checkbox1" label="A">AAA&lt;/el-checkbox>
                    &lt;el-checkbox v-model="checkbox1" label="B">BBB&lt;/el-checkbox>
                </pre>
                <div>
                    多个选项，使用el-checkbox-group {{checkbox2}}
                    <el-checkbox-group v-model="checkbox2">
                        <el-checkbox label="A">AAA</el-checkbox>
                        <el-checkbox label="B">BBB</el-checkbox>
                        <el-checkbox label="C">CCC</el-checkbox>
                        <el-checkbox label="D">DDD</el-checkbox>
                    </el-checkbox-group>
                    <pre>
                        &lt;el-checkbox-group v-model="checkbox2">
                            &lt;el-checkbox label="A">AAA&lt;/el-checkbox>
                            &lt;el-checkbox label="B">BBB&lt;/el-checkbox>
                            &lt;el-checkbox label="C">CCC&lt;/el-checkbox>
                            &lt;el-checkbox label="D">DDD&lt;/el-checkbox>
                        &lt;/el-checkbox-group>
                    </pre>
                </div>
            </p>
            <p>
                日期选择：type属性：year/month/date/dates/ week/datetime/datetimerange/daterange
                <br>format属性指定输入框格式，value-format属性指定绑定值的格式     {{date1}}<br>

                <el-date-picker v-model="date1" format="yyyy/MM/dd" value-format='yyyy-MM-dd'></el-date-picker>
    <pre>
        &lt;el-date-picker v-model="date1" format="yyyy/MM/dd" value-format='yyyy-MM-dd'>&lt;/el-date-picker>
    </pre>
            </p>
            <p>
                {{year}}
                <el-date-picker v-model="year" type="year" value-format="yyyy"></el-date-picker>
            </p>
            <p>
                日期范围：设置type="daterange"    {{date2}}<br>
                <el-date-picker type="daterange" v-model="date2" value-format='yyyy-MM-dd' range-separator="至" start-placeholder="开始日期" end-placeholder="结束日期" ></el-date-picker>
                <div>
                    &lt;el-date-picker type="daterange" v-model="date2" value-format='yyyy-MM-dd' range-separator="至" start-placeholder="开始日期" end-placeholder="结束日期" >&lt;/el-date-picker>
                </div>
            </p>
        <h4>2.表格</h4>
        见views/modules/spider/rpttnbaseiinfo.vue
        <h3>router</h3>
            &lt;router-link to="/">
            &lt;router-view>
            路由的作用，更新视图而不重新请求页面
            实现的两种方式：
            1.hash: 通过改变hash值 push(),replace(), hashChange
            2.History: 利用history 对象的新特性 history.pushState(), history.replaceState(), popState
            router 中通过mode 参数决定采用哪种方式
            <div>
                Vue.use( pluging) 使用use方法注入插件
                <pre>
                    import vueRouter from 'vue-router'
                    Vue.use(vueRouter)
                    //定义路由，每个路由映射一个组件
                    const routes=[
                        { path: '/', name: 'home', component:App },
                        { path: '/list/:id',name: 'info',component:Info}
                    ]
                    //创建router实例
                    var router = new vueRouter({
                        mode: 'hash',
                        routes
                    })
                    //挂载到vue实例
                    new Vue({
                        router
                    })
                </pre>
            </div>
        <h3>mock</h3>
        <div>
            <pre>
                // 使用 Mock
                var Mock = require('mockjs')
                var data = Mock.mock({
                    // 属性 list 的值是一个数组，其中含有 1 到 10 个元素
                    'list|1-10': [{
                        // 属性 id 是一个自增数，起始值为 1，每次增 1
                        'id|+1': 1
                    }]
                })
            </pre>
            <div>
                <h4>数据模版定义规范: 'name|rule':value</h4>
                7种生成规则格式：<br>
                'name|min-max':value <br>
                'name|count': value <br>
                'name|min-max.dmin-dmax': value <br>
                'name|min-max.dcount': value <br>
                'name|count.dmin-dmax': value <br>
                'name|count.dcount': value <br>
                'name|+step': value <br>
                <div>
                    属性值为String<br>
                    'name|min-max':string  表示重复生成一个字符串，重复次数>=min，<=max <br>
                    'name|count': string 表示重复生成一个字符串，重复count次
                </div>
                <div>
                    属性值为Number <br>
                    'name|+1': number 属性值自动加 1，初始值为 number <br>
                    'name|min-max':number 生成一个>=min,<=max 的number,number只是确定类型 <br>
                    'name|min-max.dmin-dmax': number 生成一个浮点数，整数部分大于等于 min、小于等于 max，小数部分保留 dmin 到 dmax 位 <br>
                </div>
                <div>
                    属性值为regexp
                    'name':/[a-zA-z0-9]{18}/
                </div>
            </div>
            <div>
                <h4>数据占位符定义规范</h4>
                <p>
                    @占位符， 占位符引用的是Mock.Random中的方法 <br>
                    Basic: boolean, natural, integer, float, character, string, range, date, time, datetime, now <br>
                    Image: image, dataImage <br>
                    Color: color <br>
                    Text: paragraph, sentence, word, title, cparagraph, csentence, cword, ctitle <br>
                    Name: first, last, name, cfirst, clast, cname <br>
                    web: url, domain, email, ip, tld <br>
                    address: area, region <br>
                    Helper: capitalize, upper, lower, pick, shuffle <br>
                    Miscellaneous: guid, id
                </p>
                <p>
                    <h4>通过 Mock.Random.extend() 来扩展自定义占位符 </h4>
<pre>
    Mock.Random.extend({
        entName: function() {
            var entNames=['天创云征信有限公司','杭州阿里巴巴有限公司','湖南易宝天创有限公司','深圳腾讯计算机系统有限公司'];
            return this.pick(entNames);
        },
        debtorType: function() {
            var dTypes=['ENTERPRISE','INSTITUTION','GOVERNMENT','SCHOOL','PERSONAL','OTHER'];
            return this.pick(dTypes);
        }
    })
    var data = Mock.mock({
        'enterpriseName': '@entName'
    })
</pre>
                </p>
                <p>
                    <h4>占位符也可以引用数据模板中的属性,两个属性值相同</h4>
<pre>
    var data = Mock.mock({
        'createTime': '@date',
        'updatetime': '@createTime'
    })
</pre>
                </p>
            </div>

        </div>
    </div>
</template>
<script>
    export default {
      data () {
        return {
          activeNames: ['1'],
          enterpriseName: '',
          status: '',
          radio1: 1,
          checkbox1: ['A'],
          checkbox2: [],
          date1: '',
          date2: [],
          year: '',
          items: [
              { message: 'Foo' },
              { message: 'Bar' }
          ]
        }
      },

      methods: {
        clickHandle () {
          alert('click')
        }
      }
    }
</script>
<style scope>
    .demo{
        font-size:16px;
    }
</style>