<template>
    <div class="customers container">
      <alert v-if="alert" v-bind:message="alert"></alert>
        <h1 class="page-header">用户管理系统</h1>
        <table class="table table-striped">
          <thead>
            <tr>
              <th>姓名</th>
              <th>电话</th>
              <th>邮箱</th>
              <th></th>
            </tr>
          </thead>
          <tbody>
            <tr v-for= "customer in customers" >
              
              <td>{{customer.name}}</td>
              <td>{{customer.phone}}</td>
              <td>{{customer.email}}</td>
              <td></td>
            </tr>
          </tbody>
        </table>
    </div>
</template>

<script>
import alert from "./Alert";
export default {
  name: 'customers',
  data () {
    return {
      customers: [],
      alert: "!"
    }
  },
  methods:{
    fetchCustomers(){
      this.$http.get("http://localhost:3000/customers")
        .then(function(response){
          this.customers = response.body;
          console.log(response);
        })
    }
  },
  created(){
    this.alert = this.$route.query.alert
    this.fetchCustomers();
  },
  components: {
    alert
  }
}

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>