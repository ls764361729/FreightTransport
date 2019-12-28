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
	<div style="height: 100%;background-image: url(http://localhost:8080/image/bj.png);background-size: 100% 100%;">
		<div style="height: 6%;"></div>
		<div class="login">
			<br />
			<br />
			<h1 style="color: white;">货运运后台系统</h1>
			<br />
			<Form style="width: 330px;margin: auto;" :model="user">
				<div>
					<FormItem>
						<Input type="text" v-model="user.phone" :maxlength="15" placeholder="手机号码">
						<Icon type="md-phone-portrait" slot="prepend"></Icon>
						</Input>
					</FormItem>
					<FormItem>
						<Input type="password" v-model="user.password" :maxlength="20" placeholder="密码">
						<Icon type="ios-lock-outline" slot="prepend"></Icon>
						</Input>
					</FormItem>
				</div>
				<FormItem>
					<a @click="handleSubmit()">
						<Button type="success" onclick="return false" long> 登 录 </Button>
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
					password: '',
					phone: ''
				},
				code: 1024,
				url: "http://localhost:8080"
			}
		},
		methods: {
			handleSubmit() {
				window.location.href = "/#/manager/";
				if (this.user.phone.length == 0 || this.user.phone.trim() == "") {
					this.$Message.warning('手机号码错误!(手机号码为11位)');
					return false;
				}
				if (this.user.password.length == 0 || this.user.password.trim() == "") {
					this.$Message.warning('请输入密码!');
					return false;
				}
				var th = this;
				axios.get(th.url + '/login/auth', {
					params: {
						phone: th.user.phone,
						password: th.user.password,
						sf: 0
					}
				}).then(function(res) {
					th.bd(res);
				});

				return false;
			},
			bd(res) {
				if (res.data.code == 1028) {
					this.$Message.success(res.data.message);
					localStorage.setItem('accessToken', res.data.data.sign);
					localStorage.setItem('mName', res.data.data.mName);
					localStorage.setItem('mUser', res.data.data.mUser);
					setTimeout(function() {
						window.location.href = "/manager";
					}, 900);
				} else {
					this.user.password = "";
					this.$Message.error(res.data.message);
				}
			}

		}
	}
</script>
