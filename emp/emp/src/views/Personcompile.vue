<template>
    <div>
        <el-table :data="tabledatas" border>
            <el-table-column class="b" label="序号">
                <template slot-scope="scope">
                    <span v-show="scope.row.show">{{scope.row.tab1}}</span>
                    <span v-show="!scope.row.show">{{scope.row.tab1}}</span>
                </template>
            </el-table-column>
            <el-table-column class="b" label="姓名">
                <template slot-scope="scope">
                    <el-input placeholder="请输入内容" v-show="scope.row.show" v-model="scope.row.tab2" oninput="value=value.replace(/[\u4e00-\u9fa5]{0,}$/g,'')"></el-input>
                    <span v-show="!scope.row.show">{{scope.row.tab2}}</span>
                </template>
            </el-table-column>
            <el-table-column class="b" label="工资">
                <template slot-scope="scope">
                    <el-input placeholder="请输入数字" v-show="scope.row.show" v-model="scope.row.tab3" oninput="value=value.replace(/[^\d]/g,'')"></el-input>
                    <span v-show="!scope.row.show">{{scope.row.tab3}}</span>
                </template>
            </el-table-column>
            <el-table-column class="b" label="年龄">
                <template slot-scope="scope">
                    <el-input placeholder="请输入数字" v-show="scope.row.show" v-model="scope.row.tab4" oninput="value=value.replace(/[^\d]/g,'')" maxlength="2"></el-input>
                    <span v-show="!scope.row.show">{{scope.row.tab4}}</span>
                </template>
            </el-table-column>
            <el-table-column class="b" label="入职时间">
                <template slot-scope="scope">
                    <div class="block">
    
    <el-date-picker
      v-model="scope.row.tab5" v-show="scope.row.show" 
      type="date" 
      placeholder="选择日期">
    </el-date-picker>
    <!-- <el-input placeholder="请输入内容" v-show="scope.row.show" v-model="scope.row.tab5" oninput="value=value.replace(/[^\d]/g,'')" ></el-input> -->
  </div>
                    <span v-show="!scope.row.show">{{scope.row.tab5}}</span>
                </template>
                </el-table-column>
            <el-table-column class="b" label="部门编号">
                <template slot-scope="scope">
                    <el-input placeholder="请输入数字" v-show="scope.row.show" v-model="scope.row.tab6" ></el-input>
                    <span v-show="!scope.row.show">{{scope.row.tab6}}</span>
                </template>
                </el-table-column>
            <el-table-column class="b" label="离职时间">
                <template slot-scope="scope">
                        <div class="block">
                        <el-date-picker
                        v-model="scope.row.tab7" v-show="scope.row.show" 
                        type="date" 
                         placeholder="选择日期">
                         </el-date-picker>
                        </div>
                    <span v-show="!scope.row.show">{{scope.row.tab7}}</span>
                </template>
            </el-table-column>
            
            <el-table-column label="操作">
                <template slot-scope="scope">
                    <el-button @click="scope.row.show =true" class="bc" style="width: 70px;padding-left: 10px;padding-right: 10px;">编辑</el-button>
                    <el-button @click="scope.row.show =false" class="bc" style="width: 70px;padding-left: 10px;padding-right: 10px;margin-left: 0px;">保存</el-button>
                </template>
            </el-table-column>
        </el-table>
    </div>
</template>
<script>
    export default {
        data() {
            return {
                tabledatas: [
                    { tab1: '1', tab2: '张三',tab3:'10000',tab4:'18',tab5:'Wed Sep 09 2020 00:00:00 GMT+0800 (中国标准时间)',tab6:'001',tab7:'Wed Sep 09 2020 00:00:00 GMT+0800 (中国标准时间)',show:false},
                    // { tab1: 'aaa', tab2: 'bbb' ,tab:'333',show:true},
                ]

            }
        },
        methods: {
            proving() {
            this.formData.bankName = this.formData.bankName.replace(/[^\d]/g,'');
            this.formData.bankName = this.formData.bankName.replace('.','');
            },
            inputChange(e) {
            const o = e.target;
            o.value = o.value.replace(/[^0-9]/g, ""); // 清除除了数字以外的输入的字符
            this.name = o.value;
            }
            },
             pickerOptions: {
          disabledDate(time) {
            return time.getTime() > Date.now();
          }}

    }
</script>
<style>
.bc{
    width: 70px;
    margin-left: 0px;
    margin-block: 0px;
}
.a{
    width: 50%;
}

</style>
