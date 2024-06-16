<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="spuId" prop="spuId">
      <el-input v-model="dataForm.spuId" placeholder="spuId"></el-input>
    </el-form-item>
    <el-form-item label="sku名称" prop="name">
      <el-input v-model="dataForm.name" placeholder="sku名称"></el-input>
    </el-form-item>
    <el-form-item label="所属分类id" prop="catagoryId">
      <el-input v-model="dataForm.catagoryId" placeholder="所属分类id"></el-input>
    </el-form-item>
    <el-form-item label="品牌id" prop="brandId">
      <el-input v-model="dataForm.brandId" placeholder="品牌id"></el-input>
    </el-form-item>
    <el-form-item label="默认图片" prop="defaultImage">
      <el-input v-model="dataForm.defaultImage" placeholder="默认图片"></el-input>
    </el-form-item>
    <el-form-item label="标题" prop="title">
      <el-input v-model="dataForm.title" placeholder="标题"></el-input>
    </el-form-item>
    <el-form-item label="副标题" prop="subtitle">
      <el-input v-model="dataForm.subtitle" placeholder="副标题"></el-input>
    </el-form-item>
    <el-form-item label="价格" prop="price">
      <el-input v-model="dataForm.price" placeholder="价格"></el-input>
    </el-form-item>
    <el-form-item label="重量（克）" prop="weight">
      <el-input v-model="dataForm.weight" placeholder="重量（克）"></el-input>
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
          spuId: '',
          name: '',
          catagoryId: '',
          brandId: '',
          defaultImage: '',
          title: '',
          subtitle: '',
          price: '',
          weight: ''
        },
        dataRule: {
          spuId: [
            { required: true, message: 'spuId不能为空', trigger: 'blur' }
          ],
          name: [
            { required: true, message: 'sku名称不能为空', trigger: 'blur' }
          ],
          catagoryId: [
            { required: true, message: '所属分类id不能为空', trigger: 'blur' }
          ],
          brandId: [
            { required: true, message: '品牌id不能为空', trigger: 'blur' }
          ],
          defaultImage: [
            { required: true, message: '默认图片不能为空', trigger: 'blur' }
          ],
          title: [
            { required: true, message: '标题不能为空', trigger: 'blur' }
          ],
          subtitle: [
            { required: true, message: '副标题不能为空', trigger: 'blur' }
          ],
          price: [
            { required: true, message: '价格不能为空', trigger: 'blur' }
          ],
          weight: [
            { required: true, message: '重量（克）不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/product/sku/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.spuId = data.sku.spuId
                this.dataForm.name = data.sku.name
                this.dataForm.catagoryId = data.sku.catagoryId
                this.dataForm.brandId = data.sku.brandId
                this.dataForm.defaultImage = data.sku.defaultImage
                this.dataForm.title = data.sku.title
                this.dataForm.subtitle = data.sku.subtitle
                this.dataForm.price = data.sku.price
                this.dataForm.weight = data.sku.weight
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
              url: this.$http.adornUrl(`/product/sku/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'spuId': this.dataForm.spuId,
                'name': this.dataForm.name,
                'catagoryId': this.dataForm.catagoryId,
                'brandId': this.dataForm.brandId,
                'defaultImage': this.dataForm.defaultImage,
                'title': this.dataForm.title,
                'subtitle': this.dataForm.subtitle,
                'price': this.dataForm.price,
                'weight': this.dataForm.weight
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
