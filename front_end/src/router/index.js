import Vue from 'vue'
import VueRouter from 'vue-router'
import login from '../components/login/login.vue'

Vue.use(VueRouter)

const routes = [{
		path: '/',
		name: 'login',
		component: login
	},
	/*----------------------------------------------------------------*/
	{
		path: '/driver/login',
		name: 'login',
		component: () => import('../components/login/driver.vue')
	}, {
		path: '/driver',
		name: 'driver',
		component: () => import('../components/main/driver.vue'),
		children: [{
				path: '/',
				name: '',
				component: () => import('../components/index/driver.vue'),
			}, {
				path: '/driver/index',
				name: 'index',
				component: () => import('../components/index/driver.vue'),
			}, {
				path: '/driver/all',
				name: 'all',
				component: () => import('../components/driver/ordermanager/all.vue')
			}, {
				path: '/driver/intransported',
				name: 'intransported',
				component: () => import('../components/driver/ordermanager/intransported.vue')
			}, {
				path: '/driver/tobetransported',
				name: 'tobetransported',
				component: () => import('../components/driver/ordermanager/tobetransported.vue')
			}, {
				path: '/driver/personalinfo',
				name: 'personalinfo',
				component: () => import('../components/driver/personalinfo.vue')
			}, {
				path: '/driver/vehicleinfo',
				name: 'vehicleinfo',
				component: () => import('../components/driver/vehicleinfo.vue')
			},
			{
				path: '/driver/placeanorder',
				name: 'placeanorder',
				component: () => import('../components/driver/placeanorder.vue')
			}, {
				path: '/driver/maporder',
				name: 'maporder',
				component: () => import('../components/driver/maporder.vue')
			}, {
				path: '/driver/quickorder',
				name: 'quickorder',
				component: () => import('../components/driver/quickorder.vue')
			}
		]
	},
	/*----------------------------------------------------------------*/

	{
		path: '/manager/login',
		name: 'login',
		component: () => import('../components/login/manager.vue')
	}, {
		path: '/manager',
		name: 'manager',
		component: () => import('../components/main/manager.vue'),
		children: [{
				path: '/',
				name: '',
				component: () => import('../components/index/manager.vue'),
			}, {
				path: '/manager/info',
				name: 'info',
				component: () => import('../components/manager/info/manager.vue'),
			}, {
				path: '/manager/shipper',
				name: 'shipperinfo',
				component: () => import('../components/manager/info/shipper.vue'),
			}, {
				path: '/manager/dirver',
				name: 'dirverinfo',
				component: () => import('../components/manager/info/dirver.vue'),
			}, {
				path: '/manager/vehicle',
				name: 'vehicleinfo',
				component: () => import('../components/manager/info/vehicle.vue'),
			}, {
				path: '/manager/vehicletype',
				name: 'vehicletypeinfo',
				component: () => import('../components/manager/info/vehicletype.vue'),
			}, {
				path: '/manager/collectfess',
				name: 'collectfessinfo',
				component: () => import('../components/manager/info/collectfess.vue'),
			}, {
				path: '/manager/evaluation',
				name: 'evaluation',
				component: () => import('../components/manager/info/evaluation.vue'),
			}, {
				path: '/manager/notice',
				name: 'notice',
				component: () => import('../components/manager/info/notice.vue'),
			}, {
				path: '/manager/order',
				name: 'order',
				component: () => import('../components/manager/ordermanager/all.vue'),
			}, {
				path: '/manager/complete',
				name: 'complete',
				component: () => import('../components/manager/ordermanager/complete.vue'),
			}, {
				path: '/manager/intransported',
				name: 'intransported',
				component: () => import('../components/manager/ordermanager/intransported.vue'),
			}, {
				path: '/manager/tobetransported',
				name: 'tobetransported',
				component: () => import('../components/manager/ordermanager/tobetransported.vue'),
			}, {
				path: '/manager/reportfromorder',
				name: 'tobetransported',
				component: () => import('../components/manager/reportform/order.vue'),
			}, {
				path: '/manager/systempersion',
				name: 'systempersion',
				component: () => import('../components/manager/reportform/systempersion.vue'),
			}, {
				path: '/manager/constinfo',
				name: 'constinfo',
				component: () => import('../components/manager/finance/constinfo.vue'),
			}, {
				path: '/manager/recharge',
				name: 'recharge',
				component: () => import('../components/manager/finance/recharge.vue'),
			}, {
				path: '/manager/withdrawal',
				name: 'withdrawal',
				component: () => import('../components/manager/finance/withdrawal.vue'),
			},
		]
	},

	/*----------------------------------------------------------------*/
	{
		path: '/shipper/login',
		name: 'login',
		component: () => import('../components/login/shipper.vue')
	}, {
		path: '/shipper',
		name: 'shipper',
		component: () => import('../components/main/shipper.vue'),
		children: [{
			path: '/',
			name: '',
			component: () => import('../components/index/shipper.vue'),
		}, {
			path: '/shipper/index',
			name: '',
			component: () => import('../components/index/shipper.vue'),
		}, {
			path: '/shipper/all',
			name: 'all',
			component: () => import('../components/shipper/ordermanager/all.vue')
		}, {
			path: '/shipper/complete',
			name: 'complete',
			component: () => import('../components/shipper/ordermanager/complete.vue')
		}, {
			path: '/shipper/intransported',
			name: 'intransported',
			component: () => import('../components/shipper/ordermanager/intransported.vue')
		}, {
			path: '/shipper/tobetransported',
			name: 'tobetransported',
			component: () => import('../components/shipper/ordermanager/tobetransported.vue')
		}, {
			path: '/shipper/personalinfo',
			name: 'personalinfo',
			component: () => import('../components/shipper/personalinfo.vue')
		}, {
			path: '/shipper/placeanorder',
			name: 'placeanorder',
			component: () => import('../components/shipper/placeanorder.vue')
		}]
	}
]

const router = new VueRouter({
	mode: 'hash',
	base: process.env.BASE_URL,
	routes
})

export default router
