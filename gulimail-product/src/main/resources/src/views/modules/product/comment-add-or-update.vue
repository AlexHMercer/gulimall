<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="sku_id" prop="skuId">
      <el-input v-model="dataForm.skuId" placeholder="sku_id"></el-input>
    </el-form-item>
    <el-form-item label="spu_id" prop="spuId">
      <el-input v-model="dataForm.spuId" placeholder="spu_id"></el-input>
    </el-form-item>
    <el-form-item label="商品名字" prop="spuName">
      <el-input v-model="dataForm.spuName" placeholder="商品名字"></el-input>
    </el-form-item>
    <el-form-item label="会员昵称" prop="nickName">
      <el-input v-model="dataForm.nickName" placeholder="会员昵称"></el-input>
    </el-form-item>
    <el-form-item label="星级" prop="star">
      <el-input v-model="dataForm.star" placeholder="星级"></el-input>
    </el-form-item>
    <el-form-item label="会员ip" prop="ip">
      <el-input v-model="dataForm.ip" placeholder="会员ip"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="显示状态[0-不显示，1-显示]" prop="status">
      <el-input v-model="dataForm.status" placeholder="显示状态[0-不显示，1-显示]"></el-input>
    </el-form-item>
    <el-form-item label="购买时属性组合" prop="spuAttributes">
      <el-input v-model="dataForm.spuAttributes" placeholder="购买时属性组合"></el-input>
    </el-form-item>
    <el-form-item label="点赞数" prop="followCount">
      <el-input v-model="dataForm.followCount" placeholder="点赞数"></el-input>
    </el-form-item>
    <el-form-item label="回复数" prop="replyCount">
      <el-input v-model="dataForm.replyCount" placeholder="回复数"></el-input>
    </el-form-item>
    <el-form-item label="评论图片/视频[json数据；[{type:文件类型,url:资源路径}]]" prop="resources">
      <el-input v-model="dataForm.resources" placeholder="评论图片/视频[json数据；[{type:文件类型,url:资源路径}]]"></el-input>
    </el-form-item>
    <el-form-item label="内容" prop="content">
      <el-input v-model="dataForm.content" placeholder="内容"></el-input>
    </el-form-item>
    <el-form-item label="用户头像" prop="icon">
      <el-input v-model="dataForm.icon" placeholder="用户头像"></el-input>
    </el-form-item>
    <el-form-item label="评论类型[0 - 对商品的直接评论，1 - 对评论的回复]" prop="type">
      <el-input v-model="dataForm.type" placeholder="评论类型[0 - 对商品的直接评论，1 - 对评论的回复]"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          skuId: '',
          spuId: '',
          spuName: '',
          nickName: '',
          star: '',
          ip: '',
          createTime: '',
          status: '',
          spuAttributes: '',
          followCount: '',
          replyCount: '',
          resources: '',
          content: '',
          icon: '',
          type: ''
        },
        dataRule: {
          skuId: [
            { required: true, message: 'sku_id不能为空', trigger: 'blur' }
          ],
          spuId: [
            { required: true, message: 'spu_id不能为空', trigger: 'blur' }
          ],
          spuName: [
            { required: true, message: '商品名字不能为空', trigger: 'blur' }
          ],
          nickName: [
            { required: true, message: '会员昵称不能为空', trigger: 'blur' }
          ],
          star: [
            { required: true, message: '星级不能为空', trigger: 'blur' }
          ],
          ip: [
            { required: true, message: '会员ip不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '显示状态[0-不显示，1-显示]不能为空', trigger: 'blur' }
          ],
          spuAttributes: [
            { required: true, message: '购买时属性组合不能为空', trigger: 'blur' }
          ],
          followCount: [
            { required: true, message: '点赞数不能为空', trigger: 'blur' }
          ],
          replyCount: [
            { required: true, message: '回复数不能为空', trigger: 'blur' }
          ],
          resources: [
            { required: true, message: '评论图片/视频[json数据；[{type:文件类型,url:资源路径}]]不能为空', trigger: 'blur' }
          ],
          content: [
            { required: true, message: '内容不能为空', trigger: 'blur' }
          ],
          icon: [
            { required: true, message: '用户头像不能为空', trigger: 'blur' }
          ],
          type: [
            { required: true, message: '评论类型[0 - 对商品的直接评论，1 - 对评论的回复]不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/product/comment/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.skuId = data.comment.skuId
                this.dataForm.spuId = data.comment.spuId
                this.dataForm.spuName = data.comment.spuName
                this.dataForm.nickName = data.comment.nickName
                this.dataForm.star = data.comment.star
                this.dataForm.ip = data.comment.ip
                this.dataForm.createTime = data.comment.createTime
                this.dataForm.status = data.comment.status
                this.dataForm.spuAttributes = data.comment.spuAttributes
                this.dataForm.followCount = data.comment.followCount
                this.dataForm.replyCount = data.comment.replyCount
                this.dataForm.resources = data.comment.resources
                this.dataForm.content = data.comment.content
                this.dataForm.icon = data.comment.icon
                this.dataForm.type = data.comment.type
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/product/comment/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'skuId': this.dataForm.skuId,
                'spuId': this.dataForm.spuId,
                'spuName': this.dataForm.spuName,
                'nickName': this.dataForm.nickName,
                'star': this.dataForm.star,
                'ip': this.dataForm.ip,
                'createTime': this.dataForm.createTime,
                'status': this.dataForm.status,
                'spuAttributes': this.dataForm.spuAttributes,
                'followCount': this.dataForm.followCount,
                'replyCount': this.dataForm.replyCount,
                'resources': this.dataForm.resources,
                'content': this.dataForm.content,
                'icon': this.dataForm.icon,
                'type': this.dataForm.type
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
