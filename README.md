# Toastyle
Create a toast message quickly and customize it to what you want.

## Installation
#### repositories
```gradle
maven { url 'https://jitpack.io' }
```

#### dependencies
```gradle
implementation 'com.github.eriffanani:Toastyle:1.0.0'
```

## How To Use
* Basic
```kotlin
Toastyle.makeText(context, "Basic toast")
```
<img src="https://user-images.githubusercontent.com/26743731/195301822-74eb2b47-13a6-4ea3-89fe-fdaad87c3569.gif" width="250px"/>

* Text Color
```kotlin
Toastyle.Builder(context, "Toast text color")
    .textColor(R.color.purple_200)
    .show()
```
<img src="https://user-images.githubusercontent.com/26743731/195302448-68796353-dddf-4df9-b60f-8cb9039802fe.gif" width="250px"/>

* Use Icon
```kotlin
iconLeft(R.drawable.ic_error) / iconRight(R.drawable.ic_error)
iconColor(R.color.purple_200)
```
<img src="https://user-images.githubusercontent.com/26743731/195303294-a4f87d80-c019-4e9b-9708-1829ce563c9b.gif" width="250px"/><img src="https://user-images.githubusercontent.com/26743731/195303692-917a642b-b3a7-4e2e-a21f-ce645e7cece1.gif" width="250px"/>

* Font
```kotlin
fontFamily(R.font.montserrat)
```
<img src="https://user-images.githubusercontent.com/26743731/195304711-1536f088-0207-470a-ae2c-53e8a2f0e60f.gif" width="250px"/>

* Border
```kotlin
border(R.dimen.toast_border_size, R.color.purple_200)
```
<img src="https://user-images.githubusercontent.com/26743731/195305125-bef60ea1-fd78-42b4-a91f-18970abc021b.gif" width="250px"/>

* Corner Radius
```kotlin
// All corners
cornerRadius(R.dimen.corner_toast_small) 
// Custom corner radius (Top Left, Top Right, Bottom Left, Bottom Right)
cornerRadius(R.dimen.corner_toast, 0, 0, R.dimen.corner_toast)
```
<img src="https://user-images.githubusercontent.com/26743731/195304276-661667de-b901-4d5b-9738-c09b76fc61a4.gif" width="250px"/><img src="https://user-images.githubusercontent.com/26743731/195304312-ac5e2116-25ff-4d63-88ad-343278aa3d5c.gif" width="250px"/>

* Background Color
```kotlin
backgroundColor(R.color.purple_200)
```
<img src="https://user-images.githubusercontent.com/26743731/195305885-6787d02b-9f66-49e3-92c3-7f87cb71c13f.gif" width="250px"/>

* State
```kotlin
Toastyle.success(context, "Toast success message")
```
<img src="https://user-images.githubusercontent.com/26743731/195306081-19331acb-fcbc-4591-9e67-147dbde6a603.gif" width="250px"/>

* Position
```kotlin
position(Gravity.CENTER or Gravity.END)
```
<img src="https://user-images.githubusercontent.com/26743731/195306416-2e5ecc60-1f9c-4cd2-9cd9-c4d5e8dd34b1.gif" width="250px"/>


### Licence
```license
Copyright 2022 Mukhammad Erif Fanani

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
