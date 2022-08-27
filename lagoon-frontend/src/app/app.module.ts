import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddPhoto } from './components/add-photo.component';
import { HomeComponent } from './components/home.component';
import { ImageComments } from './components/image-comments.component';
import { ImageDetail } from './components/image-detail.component';
import { Login } from './components/login.component';
import { MyAlbum } from './components/my-album.component';
import { NavBar } from './components/nav-bar.component';
import { PhotoList } from './components/photo-list.component';
import { PhotoRow } from './components/photo-row.component';
import { Register } from './components/register.component';
import { SidePanel } from './components/side-panel.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    PhotoList,
    SidePanel,
    NavBar,
    Register,
    Login,
    MyAlbum,
    AddPhoto,
    ImageComments,
    ImageDetail,
    PhotoRow,
  ],
  imports: [BrowserModule, FormsModule, HttpClientModule, AppRoutingModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
