<div align="center">

<!-- Animated Banner -->
<img src="https://capsule-render.vercel.app/api?type=waving&color=0:0d1117,30:cc0000,70:8B0000,100:0d1117&height=220&section=header&text=OpenShift%204.18&fontSize=65&fontColor=ffffff&fontAlignY=38&desc=Disconnected%20%7C%20Bare%20Metal%20%7C%20UPI%20%7C%20Air-Gapped&descAlignY=58&descSize=18&animation=fadeIn" alt="Banner" width="100%"/>

<br/>

<!-- Typing Animation -->
<img src="https://readme-typing-svg.demolab.com?font=Fira+Code&weight=700&size=16&duration=2500&pause=800&color=cc0000&center=true&vCenter=true&multiline=true&width=750&height=70&lines=🔴+Zero+Internet+%7C+Full+Control+%7C+Enterprise-Grade;☸️+15+Steps+%7C+4+Phases+%7C+Bare+Metal+UPI+Deployment" alt="Typing SVG"/>

<br/><br/>

<!-- Core Badges -->
[![OpenShift](https://img.shields.io/badge/OpenShift-4.18-cc0000?style=for-the-badge&logo=redhatopenshift&logoColor=white)](https://www.redhat.com/en/technologies/cloud-computing/openshift)
[![Kubernetes](https://img.shields.io/badge/Kubernetes-v1.31.10-326CE5?style=for-the-badge&logo=kubernetes&logoColor=white)](https://kubernetes.io/)
[![RHCOS](https://img.shields.io/badge/RHCOS-Bare_Metal-EE0000?style=for-the-badge&logo=redhat&logoColor=white)](https://docs.openshift.com/container-platform/4.18/architecture/architecture-rhcos.html)
[![HAProxy](https://img.shields.io/badge/HAProxy-Load_Balancer-1f8dd6?style=for-the-badge&logoColor=white)](http://www.haproxy.org/)

[![Quay](https://img.shields.io/badge/Quay-Mirror_Registry-40B4E5?style=for-the-badge&logoColor=white)](https://quay.io/)
[![Apache](https://img.shields.io/badge/Apache-Ignition_Server-D22128?style=for-the-badge&logo=apache&logoColor=white)](https://httpd.apache.org/)
[![UPI](https://img.shields.io/badge/Install-UPI_Method-orange?style=for-the-badge&logoColor=white)]()
[![Air-Gapped](https://img.shields.io/badge/Network-Air--Gapped-111111?style=for-the-badge&logoColor=white)]()

<br/>

**[📥 Download Guide](#-download-the-guide)** &nbsp;•&nbsp;
**[🏗️ Architecture](#️-cluster-architecture)** &nbsp;•&nbsp;
**[📋 4 Phases](#-deployment-phases)** &nbsp;•&nbsp;
**[⚠️ Critical Steps](#️-critical-steps-at-a-glance)** &nbsp;•&nbsp;
**[🏭 Who Is This For](#-who-is-this-for)**

<br/>

> 🔴 **A complete step-by-step breakdown of deploying a fully disconnected OpenShift cluster from scratch.**
> No internet. No shortcuts. Full control.

</div>

---

## 📥 Download the Guide

<div align="center">

[![Download PDF](https://img.shields.io/badge/⬇️_Download_Full_PDF_Guide-OCP_4.18_Disconnected_Deployment-cc0000?style=for-the-badge&logo=adobeacrobatreader&logoColor=white)](./OCP_4.18_Disconnected_Deployment.pdf)

*15 Steps · 4 Phases · Complete Air-Gapped UPI Deployment*

</div>

---

## 🗺️ Deployment Phases

<div align="center">

```
╔══════════════════════════════════════════════════════════════════════════════╗
║               DISCONNECTED OCP 4.18 — DEPLOYMENT JOURNEY                    ║
╠══════════════╦═════════════════════╦══════════════════╦══════════════════════╣
║   PHASE 01   ║      PHASE 02       ║    PHASE 03      ║       PHASE 04       ║
║ Preparation  ║  Infrastructure     ║   Cluster        ║   Verification &     ║
║              ║     Setup           ║  Installation    ║     Go-Live          ║
╠══════════════╬═════════════════════╬══════════════════╬══════════════════════╣
║  Steps 01–03 ║   Steps 04–07       ║  Steps 08–13     ║    Steps 14–15       ║
║              ║                     ║                  ║                      ║
║ ▸ Planning   ║ ▸ Mirror Registry   ║ ▸ Bootstrap      ║ ▸ Cluster Health     ║
║ ▸ DNS Setup  ║ ▸ Image Mirroring   ║ ▸ Master Nodes   ║ ▸ Go-Live Sign-off   ║
║ ▸ PKI / CA   ║ ▸ HAProxy LB       ║ ▸ Worker Nodes   ║                      ║
║              ║ ▸ install-config    ║ ▸ CSR Approval   ║                      ║
╚══════════════╩═════════════════════╩══════════════════╩══════════════════════╝
```

</div>

| 🔴 Phase | Name | Steps | Focus |
|:--------:|:-----|:-----:|:------|
| **01** | Preparation | Steps 01–03 | 🟧 Foundation & Planning |
| **02** | Infrastructure Setup | Steps 04–07 | 🔧 Mirror Registry, LB, DNS |
| **03** | Cluster Installation | Steps 08–13 | ☸️ Bootstrap → Masters → Workers |
| **04** | Verification & Go-Live | Steps 14–15 | ✅ Health Checks & Sign-off |

---

## 🏗️ Cluster Architecture

```
                    ┌──────────────────────────────────────────────┐
                    │       DISCONNECTED OCP 4.18 CLUSTER          │
                    └──────────────────────────────────────────────┘

  External Traffic
        │
        ▼
┌──────────────────┐
│   HAProxy LB     │  ← Routes API (:6443) and Ingress (:80/:443)
└────────┬─────────┘
         │
         ├─────────────────────────────────────────┐
         │                                         │
         ▼                                         ▼
┌─────────────────┐                   ┌────────────────────────────┐
│   Bootstrap     │                   │      Control Plane          │
│   Node          │──── ignition ───▶ │                            │
│  (temporary)    │                   │  Master-1 │ Master-2        │
└─────────────────┘                   │           │ Master-3        │
                                      └────────────────────────────┘
                                                  │
                                                  ▼
                                      ┌────────────────────────────┐
                                      │        Worker Nodes         │
                                      │  Worker-1   │   Worker-2   │
                                      └────────────────────────────┘

  ┌──────────────────────────────────────────────────────────────┐
  │               INTERNAL SERVICES  (Air-Gapped)                │
  │                                                              │
  │  ┌─────────────────────┐    ┌─────────────────────────────┐ │
  │  │   Quay Registry     │    │   Apache HTTPD              │ │
  │  │   (Internal Mirror) │    │   (Ignition Server)         │ │
  │  │                     │    │                             │ │
  │  │  All OCP images     │    │  bootstrap.ign              │ │
  │  │  pre-mirrored       │    │  master.ign                 │ │
  │  │  via oc-mirror      │    │  worker.ign                 │ │
  │  └─────────────────────┘    └─────────────────────────────┘ │
  │                                                              │
  │     Internal DNS  ·  Custom CA / TLS Chain  ·  NTP          │
  └──────────────────────────────────────────────────────────────┘

  ╔════════════════════════════════════════════════╗
  ║    ⚠️  STRICT BOOT ORDER — NO EXCEPTIONS!      ║
  ║                                                ║
  ║   1️⃣ Bootstrap → 2️⃣ Masters → 3️⃣ Workers       ║
  ╚════════════════════════════════════════════════╝
```

---

## ✨ Key Highlights

<table>
<tr>
<td valign="top" width="50%">

### 🔒 Zero Internet — Fully Air-Gapped
All container images pre-mirrored to an **internal Quay registry** before installation begins. Not a single outbound call is made during the entire deployment.

### 🪞 imageDigestSources
Redirects every `quay.io` pull to your **internal mirror** via digest-based routing — ensures byte-for-byte image integrity with no tampering risk.

### 🔐 Custom CA Certificates
Full **TLS trust chain** built internally — registry, API server, and ingress all served over verified HTTPS with no external CA dependency.

</td>
<td valign="top" width="50%">

### 📋 CSR Approval — Manual Two-Round
UPI requirement: worker nodes submit **Certificate Signing Requests** that must be manually approved in two rounds. Miss this → nodes never join.

### 📦 Strict Boot Order
`Bootstrap → Masters → Workers` — hardcoded sequence enforced by the OpenShift installer. Any deviation = cluster never forms.

### ⚙️ Full Infrastructure Ownership
UPI means **you own everything** — DNS, load balancer, DHCP, TFTP, ignition serving. Nothing is auto-provisioned for you.

</td>
</tr>
</table>

---

## ⚠️ Critical Steps at a Glance

<div align="center">

```
┌────────┬──────────────────────────┬─────────────────────────────────────────┐
│  Step  │          What            │             Why Critical                │
├────────┼──────────────────────────┼─────────────────────────────────────────┤
│  04    │  Mirror Registry Setup   │ Missing images = install fails, period  │
│  07    │  install-config.yaml     │ Wrong config = no images pulled         │
│  10    │  Boot Order              │ Wrong order = cluster never forms       │
│  13    │  Approve CSRs            │ Skipping = nodes stuck in NotReady      │
└────────┴──────────────────────────┴─────────────────────────────────────────┘
```

</div>

| 🔴 Step | What | Why It Will Break You |
|:-------:|:-----|:----------------------|
| **Step 04** | Mirror Registry Setup | Missing even one image layer = install fails with zero recovery path |
| **Step 07** | `install-config.yaml` | One wrong field = no images pulled from internal mirror |
| **Step 10** | Boot Order Enforcement | Out-of-order boot = etcd quorum never established |
| **Step 13** | Approve CSRs | Two-round approval skipped = workers stuck in `NotReady` forever |

---

## 🛠️ Tech Stack

<div align="center">

| Layer | Component | Version | Role |
|:------|:----------|:-------:|:-----|
| ![OCP](https://img.shields.io/badge/-OpenShift-cc0000?logo=redhatopenshift&logoColor=white&style=flat-square) **Platform** | OpenShift | `4.18` | Container orchestration platform |
| ![K8s](https://img.shields.io/badge/-Kubernetes-326CE5?logo=kubernetes&logoColor=white&style=flat-square) **Engine** | Kubernetes | `v1.31.10` | Underlying cluster engine |
| ![RHCOS](https://img.shields.io/badge/-RHCOS-EE0000?logo=redhat&logoColor=white&style=flat-square) **OS** | RHCOS + RHEL | — | Immutable node OS + bastion host |
| ![HAProxy](https://img.shields.io/badge/-HAProxy-1f8dd6?style=flat-square) **LB** | HAProxy | — | API (:6443) + Ingress routing |
| ![Quay](https://img.shields.io/badge/-Quay-40B4E5?style=flat-square) **Registry** | Quay (Internal) | — | Pre-mirrored OCP image storage |
| ![Apache](https://img.shields.io/badge/-Apache-D22128?logo=apache&logoColor=white&style=flat-square) **Ignition** | Apache HTTPD | — | Serves `.ign` configs to nodes |
| ![UPI](https://img.shields.io/badge/-UPI_Method-orange?style=flat-square) **Install** | UPI | — | User Provisioned Infrastructure |

</div>

---

## 🏭 Who Is This For?

> Disconnected (air-gapped) environments are **not optional** in these sectors — they're **regulatory requirements**.

<div align="center">

<table>
<tr>
<td align="center" width="20%">🏦<br/><strong>Banking &<br/>Finance</strong><br/><br/><sub>Strict network isolation<br/>policies & compliance</sub></td>
<td align="center" width="20%">🛡️<br/><strong>Defense &<br/>Government</strong><br/><br/><sub>Classified networks &<br/>sovereign cloud</sub></td>
<td align="center" width="20%">🏥<br/><strong>Healthcare</strong><br/><br/><sub>HIPAA compliance &<br/>data residency laws</sub></td>
<td align="center" width="20%">⚡<br/><strong>Critical<br/>Infrastructure</strong><br/><br/><sub>Power grids,<br/>telecom, utilities</sub></td>
<td align="center" width="20%">🏭<br/><strong>Manufacturing</strong><br/><br/><sub>OT/IT network<br/>separation</sub></td>
</tr>
</table>

</div>

---

## 📖 Related Article

<div align="center">

[![LinkedIn Article](https://img.shields.io/badge/📖_Read_Full_Breakdown_on-LinkedIn-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/shivang-bhardwaj-7a4516242/)

***How I Deployed a Fully Disconnected OpenShift 4.18 UPI Cluster — A Complete Breakdown***

</div>

---

## 👨‍💻 Author

<div align="center">

**Shivang Bhardwaj**
*DevOps Engineer · OpenShift · Kubernetes · Linux · Cloud (AWS, Azure, GCP)*

<br/>

[![LinkedIn](https://img.shields.io/badge/LinkedIn-shivang--bhardwaj-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/shivang-bhardwaj-7a4516242/)
[![GitHub](https://img.shields.io/badge/GitHub-shivang8123-181717?style=for-the-badge&logo=github&logoColor=white)](https://github.com/shivang8123)
[![Twitter](https://img.shields.io/badge/Twitter-Shivang8123-1DA1F2?style=for-the-badge&logo=twitter&logoColor=white)](https://x.com/Shivang8123)
[![Email](https://img.shields.io/badge/Email-thakurshivangbhardwaj-EA4335?style=for-the-badge&logo=gmail&logoColor=white)](mailto:thakurshivangbhardwaj@gmail.com)

<br/>

<img src="https://github-readme-stats.vercel.app/api?username=shivang8123&show_icons=true&theme=tokyonight&hide_border=true&count_private=true" height="150" alt="GitHub Stats"/>
&nbsp;&nbsp;
<img src="https://github-readme-stats.vercel.app/api/top-langs/?username=shivang8123&layout=compact&theme=tokyonight&hide_border=true" height="150" alt="Top Languages"/>

<br/>

<img src="https://github-readme-streak-stats.herokuapp.com/?user=shivang8123&theme=tokyonight&hide_border=true" height="150" alt="Streak"/>

</div>

---

<div align="center">

<br/>

> *"In connected installs, the cloud fills the gaps.*
> *In disconnected installs — every image, cert, and binary is your responsibility."*
>
> — Shivang Bhardwaj

<br/>

![Visitor Count](https://komarev.com/ghpvc/?username=shivang8123&label=Profile+Views&color=cc0000&style=flat-square)

<img src="https://capsule-render.vercel.app/api?type=waving&color=0:0d1117,30:cc0000,70:8B0000,100:0d1117&height=120&section=footer" width="100%"/>

</div>
