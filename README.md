<div id="top"></div>
<!--
*** Thanks for checking out the Best-README-Template. If you have a suggestion
*** that would make this better, please fork the repo and create a pull request
*** or simply open an issue with the tag "enhancement".
*** Don't forget to give the project a star!
*** Thanks again! Now go create something AMAZING! :D
-->

# StackLounge-Backend

Scrapy, Django, GraphQL 을 사용해 StackShare와 유사한 서비스 기능을 구현하였습니다.

StackLounge 서비스의 벡엔드 코드 입니다.

<!-- ABOUT THE PROJECT -->
## About The Project

Scrapy 를 통해 수집된 서비스 별 사용되는 기술 스택을 MongoDB에 저장하고, 
해당 정보를 Django 벡엔드의 GrqphQL API를 통해 제공하는 프로젝트입니다.

### Built With

* [Django](https://www.djangoproject.com)
* [GraphQL](https://graphql.org)
* [Scrapy](https://scrapy.org)
* [Graphene](https://graphene-python.org)
* [MongoDB](https://www.mongodb.com)
* [Docker](https://www.docker.com)
* [Firebase](https://firebase.google.com)

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

  Ubuntu 20.04(LTS)

  Python 3.9

  Docker 20.10
  버전에서 확인하였습니다.

<!-- Prerequisites -->
### Prerequisites

  도커와 도커 컴포즈를 설치 해야 합니다.

  도커와 도커 컴포즈를 설치하는 방법은 아래 링크를 참고하세요.

  Docker Installation
  * [Ubuntu 에서 Docker 설치](https://docs.docker.com/engine/install/ubuntu/)

  Docker-Compose Installation
  * [Ubuntu 에서 Docker-Compose 설치](https://docs.docker.com/compose/install/)

<!-- Usage -->
### Usage

1. 저장소를 클론합니다.
   ```sh
   git clone https://github.com/KKodiac/stacklounge-backend.git
   ```
2. docker-compose 를 활용해 실행합니다.
  
   ```sh
    # Docker Hub 에 이미 올라가 있는 이미지를 사용합니다. 
    # https://hub.docker.com/repository/docker/seanhong2000/app
    docker-compose up -d
   ```
  
3. localhost에서 확인합니다.
  
   ```sh
    http://localhost:8000/graphql -> GraphiQL UI
    http://localhost:8081/ -> MongoDB with Express
    http://localhost:27017/ -> MongoDB
   ```

4. GraphQL 스키마 정보
  ```
    allCompanies: [
      companyName: String,
      techStack: [String],
    ]
  ```
  ```
    allTools: [
      name: String,
      imageUrl: String,
      description: String,
      cananicalUrl: String,
      ossRepo: String,
      slug: String,
      title: String,
      websiteUrl: String,
    ]
  ```
  ```
    toolByName(name: String!): [
      name: String,
      imageUrl: String,
      description: String,
      cananicalUrl: String,
      ossRepo: String,
      slug: String,
      title: String,
      websiteUrl: String,
    ]
  ```
  ```
    toolBySlug(slug: String!): [
      name: String,
      imageUrl: String,
      description: String,
      cananicalUrl: String,
      ossRepo: String,
      slug: String,
      title: String,
      websiteUrl: String,
    ]
  ```
  ```
    companyByName(name: String!): [
      companyName: String,
      techStack: [String],
    ]
  ```



<p align="right">(<a href="#top">back to top</a>)</p>

<!-- Original Project Layout -->
## Original Project Layout

![image](https://raw.githubusercontent.com/KPUCE2021SP/LiC/develop/.github/images/backbone.jpeg)

<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE.txt` for more information.

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- ACKNOWLEDGMENTS -->
## Acknowledgments && Team Members

Project Link: [https://github.com/KPUCE2021SP/LiC](https://github.com/KPUCE2021SP/LiC)

* [홍성민](https://github.com/KKodiac) - Scrapy, MongoDB, Django, Docker, Graphql, EC2, Client(UI, Home, Search)
* [배준일](https://github.com/bjo6300) - Client(Community, Base UI), RealtimeDB
* [한상우](https://github.com/sktkddn777) - Scrapy, Cloud Functions, GithubAPI, MongoDB, RealtimeDB, PapagoAPI


<p align="right">(<a href="#top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/github_username/repo_name.svg?style=for-the-badge
[contributors-url]: https://github.com/github_username/repo_name/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/github_username/repo_name.svg?style=for-the-badge
[forks-url]: https://github.com/github_username/repo_name/network/members
[stars-shield]: https://img.shields.io/github/stars/github_username/repo_name.svg?style=for-the-badge
[stars-url]: https://github.com/github_username/repo_name/stargazers
[issues-shield]: https://img.shields.io/github/issues/github_username/repo_name.svg?style=for-the-badge
[issues-url]: https://github.com/github_username/repo_name/issues
[license-shield]: https://img.shields.io/github/license/github_username/repo_name.svg?style=for-the-badge
[license-url]: https://github.com/github_username/repo_name/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/linkedin_username
[product-screenshot]: images/screenshot.png
