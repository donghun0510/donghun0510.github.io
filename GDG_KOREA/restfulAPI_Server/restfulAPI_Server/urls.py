from django.urls import path, include
from addresses import views
# Wire up our API using automatic URL routing.
# Additionally, we include login URLs for the browsable API.


urlpatterns = [
    path('addresses/', views.address_list),
    path('addresses/<int:pk>/', views.address),
    path('/login/', views.login),
    path('api-auth/', include('rest_framework.urls', namespace='rest_framework'))
]
