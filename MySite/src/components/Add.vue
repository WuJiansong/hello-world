<template>
    <div class="add container">
        <h1 class="page-header">添加用户</h1>
        <form v-on:submit="addcustomer">
            <div class="well">
                <h4>用户信息</h4>
                <div class="form-group">
                    <label>姓名</label>
                    <input type="text" class="form-control" placeholder="name" v-model="customer.name">
                </div>
                <div class="form-group">
                    <label>电话</label>
                    <input type="text" class="form-control" placeholder="phone" v-model="customer.phone">
                </div>
                <div class="form-group">
                    <label>邮箱</label>
                    <input type="text" class="form-control" placeholder="email" v-model="customer.email">
                </div>
                <button type="submit" class="btn btn-primary">Add</button>
            </div>
        </form>        
    </div>
</template>

<script>
export default {
  name: 'add',
  data () {
    return {
      customer:{}
    }
  },
  methods:{
      addcustomer(e){
          if(!this.customer.name || !this.customer.phone || !this.customer.email){
              console.log("请添加对应的信息");
          }else{
              let newCustomer = {
                  name:this.customer.name,
                  phone:this.customer.phone,
                  email:this.customer.email
              }
              this.$http.post("http://localhost:3000/customers",newCustomer)
                .then(function(response){
                    //console.log(response);
                    this.$router.push({path:"/customers",query:{alert:"用户信息添加成功"}});
                })
                e.preventDefault();
          }
          e.preventDefault();
      }
      }
  }

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>