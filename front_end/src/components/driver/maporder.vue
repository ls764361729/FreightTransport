<template>
    <div >
		<iframe width="1120px" height="570px" v-show="iframeState" id="show-iframe"  frameborder=0 name="showHere" scrolling=auto :src="url"></iframe>
    </div>
</template>

<script>
export default {
  name: 'hello',
  data () {
    return {
      iframeState:true,
			url:"http://localhost:8080/image/dtxc.html?id="
    }
  },
  mounted(){
    const oIframe = document.getElementById('show-iframe');
    const deviceWidth = document.documentElement.clientWidth;
    const deviceHeight = document.documentElement.clientHeight;
  },
	created(){
		this.url = "http://localhost:8080/image/dtxc.html?id="+localStorage.getItem("mUser");
	},
  methods:{
  }
}

</script>
<style scoped>


</style>