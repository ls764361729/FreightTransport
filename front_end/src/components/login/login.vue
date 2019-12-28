<style>
	.login{
	height: 300px;
    width: 450px;
    top: 100px;
    position: relative;
	border-radius: 30px;
    text-align: center;
	background: rgba(0,50,100,0.8);
	margin: auto;
	}
</style>
<template>
	<div style="height: 100%;background-image: url(http://localhost:8080/image/login.png);background-size: 100% 100%;">
		<div style="height: 6%;"></div>
		<div class="login">
			<br />
			<br />
			<h1 style="color: white;">货运运</h1>
			<br />
			<Form style="width: 350px;margin: auto;" :model="user">

				<FormItem>
					<a @click="submitmanager()">
						<Button type="success" onclick="return false" long> 管理员 </Button>
						<br />
					</a><br />
					<a @click="submitshipper()">
						<Button type="success" onclick="return false" long> 下单拉货 </Button>
						<br />
					</a><br />
					<a @click="submitdriver()">
						<Button type="success" onclick="return false" long> 司机 </Button>
						<br />
					</a>
				</FormItem>
			</Form>
		</div>
		<div style="height:6%;"></div>
	</div>
</template>
<script>
	export default {
		data() {
			return {
				user: {
					name: '',
					password: '',
					phone: '',
				},
				code: 1024
			}
		},
		methods: {
			submitmanager() {
				window.location.href = "/#/manager/login";
			},
			submitshipper() {
				window.location.href = "/#/shipper/login";
			},
			submitdriver() {
				window.location.href = "/#/driver/login";
			}
		}
	}
</script>
