import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddPhoto } from './components/add-photo.component';
import { HomeComponent } from './components/home.component';
import { ImageDetail } from './components/image-detail.component';
import { Login } from './components/login.component';
import { MyAlbum } from './components/my-album.component';
import { Register } from './components/register.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: '/home',
    pathMatch: 'full',
  },
  {
    path: 'home',
    component: HomeComponent,
  },
  {
    path: 'register',
    component: Register,
  },
  {
    path: 'login',
    component: Login,
  },
  {
    path: 'my-album',
    component: MyAlbum,
  },
  {
    path: 'add-photo',
    component: AddPhoto,
  },
  {
    path: 'image-detail/:id',
    component: ImageDetail,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
