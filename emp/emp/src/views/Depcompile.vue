<template>
    <div>
        <el-table :data="tabledatas" border>
            <el-table-column label="部门编号">
                <template slot-scope="scope">
                    <span v-show="scope.row.show">{{scope.row.tab1}}</span>
                    <span v-show="!scope.row.show">{{scope.row.tab1}}</span>
                </template>
            </el-table-column>
            <el-table-column label="部门名称">
                <template slot-scope="scope">
                    <el-input placeholder="请输入内容" v-show="scope.row.show" v-model="scope.row.tab2"></el-input>
                    <span v-show="!scope.row.show">{{scope.row.tab2}}</span>
                </template>
            </el-table-column>
            <el-table-column label="创建日期">
                <template slot-scope="scope">
                    <el-input placeholder="请输入内容" v-show="scope.row.show" v-model="scope.row.tab3"></el-input>
                    <span v-show="!scope.row.show">{{scope.row.tab3}}</span>
                </template>
            </el-table-column>
            <el-table-column label="操作">
                <template slot-scope="scope" width="75px">
                    <el-button @click="scope.row.show =true" class="a"  style="
    width: 70px;
    padding-left: 10px;
    padding-right: 10px;
">编辑</el-button>
                    <el-button @click="scope.row.show =false" class="a" style="
    width: 70px;
    padding-left: 10px;
    padding-right: 10px;
">保存</el-button>
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
                    { tab1: '111', tab2: '2222',tab3:'333',show:false},
                    // { tab1: 'aaa', tab2: 'bbb' ,tab:'333',show:true},
                ],
            }
        },
    }
</script>
<style>
.a{
    width: 47.338px;
    margin-left: 0px;
}
</style>
