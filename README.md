<div align="center">

<!-- ═══════════════════════════════════════════════════════════════════════ -->
<!--                        ANIMATED HEADER BANNER                         -->
<!-- ═══════════════════════════════════════════════════════════════════════ -->

<img src="https://capsule-render.vercel.app/api?type=waving&color=0:0d1117,20:1a0000,50:cc0000,80:8B0000,100:0d1117&height=250&section=header&text=OpenShift%204.18&fontSize=72&fontColor=ffffff&fontAlignY=40&desc=🔴%20Disconnected%20%7C%20Bare%20Metal%20%7C%20UPI%20%7C%20Air-Gapped%20Enterprise%20Deployment&descAlignY=60&descSize=16&animation=fadeIn" alt="Banner" width="100%"/>

<br/>

<!-- Typing Animation — dual line -->
<img src="https://readme-typing-svg.demolab.com?font=Fira+Code&weight=700&size=17&duration=2500&pause=900&color=FF4444&center=true&vCenter=true&multiline=true&width=800&height=80&lines=🔴+Zero+Internet+%7C+Zero+Compromise+%7C+100%25+Air-Gapped;☸️+15+Steps+%7C+4+Phases+%7C+Complete+Bare+Metal+UPI+Guide" alt="Typing SVG"/>

<br/><br/>

<!-- ─── Platform Badges ─────────────────────────────────────────────────── -->
[![OpenShift](https://img.shields.io/badge/OpenShift-4.18-cc0000?style=for-the-badge&logo=redhatopenshift&logoColor=white)](https://www.redhat.com/en/technologies/cloud-computing/openshift)
[![Kubernetes](https://img.shields.io/badge/Kubernetes-v1.31.10-326CE5?style=for-the-badge&logo=kubernetes&logoColor=white)](https://kubernetes.io/)
[![RHCOS](https://img.shields.io/badge/RHCOS-4.18-EE0000?style=for-the-badge&logo=redhat&logoColor=white)](https://docs.openshift.com/container-platform/4.18/architecture/architecture-rhcos.html)
[![RHEL](https://img.shields.io/badge/RHEL-9.x-EE0000?style=for-the-badge&logo=redhat&logoColor=white)](https://www.redhat.com/en/technologies/linux-platforms/enterprise-linux)

<!-- ─── Infrastructure Badges ───────────────────────────────────────────── -->
[![HAProxy](https://img.shields.io/badge/HAProxy-Load_Balancer-1f8dd6?style=for-the-badge&logoColor=white)](http://www.haproxy.org/)
[![Quay](https://img.shields.io/badge/Quay-Mirror_Registry-40B4E5?style=for-the-badge&logoColor=white)](https://quay.io/)
[![Apache](https://img.shields.io/badge/Apache_HTTPD-Ignition_Server-D22128?style=for-the-badge&logo=apache&logoColor=white)](https://httpd.apache.org/)
[![Bind DNS](https://img.shields.io/badge/BIND-DNS_Server-009933?style=for-the-badge&logoColor=white)]()

<!-- ─── Status Badges ────────────────────────────────────────────────────── -->
[![UPI](https://img.shields.io/badge/Install_Method-UPI-FF6600?style=for-the-badge&logoColor=white)]()
[![Air-Gapped](https://img.shields.io/badge/Network-Air--Gapped-111111?style=for-the-badge&logoColor=white)]()
[![TLS](https://img.shields.io/badge/Security-Custom_CA_TLS-2ecc71?style=for-the-badge&logo=letsencrypt&logoColor=white)]()
[![License](https://img.shields.io/badge/License-MIT-yellow?style=for-the-badge)](./LICENSE)

<br/>

<!-- Navigation Links -->
**[📥 Download](#-download-the-guide)** &nbsp;•&nbsp;
**[🔍 Overview](#-overview)** &nbsp;•&nbsp;
**[🏗️ Architecture](#️-full-cluster-architecture)** &nbsp;•&nbsp;
**[📋 All 15 Steps](#-complete-15-step-deployment-walkthrough)** &nbsp;•&nbsp;
**[🔐 Security](#-security-deep-dive)** &nbsp;•&nbsp;
**[⚠️ Troubleshooting](#️-troubleshooting-guide)** &nbsp;•&nbsp;
**[📖 LinkedIn](#-related-article)**

<br/>

> ### 🔴 The most complete open-source guide to deploying OpenShift 4.18 in a fully disconnected, air-gapped, bare-metal UPI environment.
> No internet. No cloud provisioner. No automation crutch. **You own every layer.**

</div>

---

## 📌 Table of Contents

<details open>
<summary><b>Click to expand / collapse</b></summary>

- [📥 Download the Guide](#-download-the-guide)
- [🔍 Overview](#-overview)
- [✨ Feature Highlights](#-feature-highlights)
- [🛠️ Full Tech Stack](#️-full-tech-stack)
- [🏗️ Full Cluster Architecture](#️-full-cluster-architecture)
  - [Network Topology](#-network-topology)
  - [Component Interaction Map](#-component-interaction-map)
  - [Boot Sequence Flow](#-boot-sequence-flow)
  - [Order Lifecycle State Machine](#-order-lifecycle-state-machine)
- [📋 Deployment Phases — Overview](#-deployment-phases--overview)
- [📖 Complete 15-Step Deployment Walkthrough](#-complete-15-step-deployment-walkthrough)
  - [Phase 01 — Preparation](#-phase-01--preparation-steps-0103)
  - [Phase 02 — Infrastructure Setup](#-phase-02--infrastructure-setup-steps-0407)
  - [Phase 03 — Cluster Installation](#-phase-03--cluster-installation-steps-0813)
  - [Phase 04 — Verification & Go-Live](#-phase-04--verification--go-live-steps-1415)
- [⚠️ Critical Steps At a Glance](#️-critical-steps-at-a-glance)
- [🔐 Security Deep Dive](#-security-deep-dive)
- [🗄️ Prerequisites & Resource Requirements](#️-prerequisites--resource-requirements)
- [⚙️ Key Configuration Files](#️-key-configuration-files)
- [🧪 Verification Commands](#-verification-commands)
- [🛠️ Troubleshooting Guide](#️-troubleshooting-guide)
- [🏭 Who Is This For](#-who-is-this-for)
- [🗺️ Roadmap](#️-roadmap)
- [📖 Related Article](#-related-article)
- [👨‍💻 Author](#-author)

</details>

---

## 📥 Download the Guide

<div align="center">

[![Download PDF](https://img.shields.io/badge/⬇️_DOWNLOAD_FULL_PDF_GUIDE-OCP_4.18_Disconnected_Deployment-cc0000?style=for-the-badge&logo=adobeacrobatreader&logoColor=white&labelColor=8B0000)](./OCP_4.18_Disconnected_Deployment.pdf)

**15 Steps · 4 Phases · Complete Air-Gapped Bare Metal UPI Deployment**

*Includes: all config templates · DNS records · HAProxy config · install-config.yaml · CSR approval scripts*

</div>

---

## 🔍 Overview

<table>
<tr>
<td width="60%">

**OpenShift 4.18 Disconnected UPI** is the hardest install path Red Hat offers — and the most powerful.

Unlike IPI (Installer Provisioned Infrastructure) or cloud-based installs where automation handles DNS, load balancers, and image pulls from the internet, **UPI in a disconnected environment means you are the cloud.**

Every image must be mirrored before day zero. Every DNS record must exist before bootstrap boots. Every certificate must be trusted before the API server starts. There is **no retry from the internet** — if something is missing, the install fails silently and you debug from scratch.

**This guide exists so you don't have to learn that the hard way.**

</td>
<td width="40%" align="center">

**Environment at a Glance**

| Property | Value |
|:---------|:------|
| 🔴 **OCP Version** | 4.18 |
| ☸️ **K8s Version** | v1.31.10 |
| 🖥️ **Install Method** | UPI — Bare Metal |
| 🌐 **Network** | Fully Air-Gapped |
| 🏗️ **Bootstrap** | 1 node (temporary) |
| 👑 **Masters** | 3 nodes (etcd quorum) |
| ⚙️ **Workers** | 2+ nodes |
| 🪞 **Registry** | Internal Quay Mirror |
| 🔐 **TLS** | Custom CA chain |

</td>
</tr>
</table>

---

## ✨ Feature Highlights

<table>
<tr>
<td valign="top" width="50%">

### 🔒 Zero-Internet Architecture
All container images, operator bundles, and release payloads are **pre-mirrored** to an internal Quay registry using `oc-mirror`. Not a single outbound HTTP call is made during deployment. The cluster is isolated from day zero.

### 🪞 imageDigestSources — Digest-Based Routing
The `install-config.yaml` uses `imageDigestSources` (not `imageContentSources`) in OCP 4.18 to redirect every `quay.io/openshift-release-dev` pull to your internal registry. Digest-pinned pulls guarantee **byte-for-byte image integrity** — no tag mutation attacks possible.

### 🔐 Custom Internal CA Chain
Three-layer PKI: **Root CA → Intermediate CA → Leaf certs**. The registry cert, API server cert, and ingress wildcard cert all chain to your internal root. Every node trusts this chain via `additionalTrustBundle` in `install-config.yaml`.

### 📋 Two-Round CSR Approval (UPI Requirement)
Worker nodes submit **Certificate Signing Requests** in two rounds — node bootstrapper CSRs first, then serving CSRs. Both must be approved manually. Automated CSR approval is an IPI feature — in UPI, you do it yourself.

</td>
<td valign="top" width="50%">

### 📦 Strict Bootstrap → Master → Worker Order
The etcd cluster forms only when all 3 masters join. Bootstrap assists etcd bootstrap until quorum, then becomes irrelevant. Workers join only after the API is stable. **Order is not a suggestion — it's enforced by the installer.**

### ⚙️ Full Infrastructure Ownership
You configure and maintain:
- **BIND DNS** — forward + reverse zones, SRV records
- **HAProxy** — API (TCP:6443), Machine Config (TCP:22623), HTTP/S ingress
- **DHCP** — static MACs for all nodes
- **TFTP/PXE** or ISO boot for RHCOS
- **Apache HTTPD** — ignition file serving

### 🩺 Actuator-Based Health Probes
The cluster exposes `/healthz`, `/readyz`, and `/livez` endpoints at the API server level. The guide walks through interpreting each during the install — useful to know when bootstrap is safe to remove.

### 🔄 Operator Mirroring — Full Catalog
`oc-mirror` mirrors not just the release payload but also the **Operator Lifecycle Manager (OLM) catalog** — so you can install operators like Logging, Monitoring, and ACM fully offline post-install.

</td>
</tr>
</table>

---

## 🛠️ Full Tech Stack

<div align="center">

| Layer | Component | Version | Role in Deployment |
|:------|:----------|:-------:|:-------------------|
| ![OCP](https://img.shields.io/badge/-OpenShift-cc0000?logo=redhatopenshift&logoColor=white&style=flat-square) **Platform** | OpenShift Container Platform | `4.18` | The target cluster platform |
| ![K8s](https://img.shields.io/badge/-Kubernetes-326CE5?logo=kubernetes&logoColor=white&style=flat-square) **Engine** | Kubernetes | `v1.31.10` | Underlying orchestration engine |
| ![RHCOS](https://img.shields.io/badge/-RHCOS-EE0000?logo=redhat&logoColor=white&style=flat-square) **Node OS** | Red Hat CoreOS | `4.18.x` | Immutable OS for all cluster nodes |
| ![RHEL](https://img.shields.io/badge/-RHEL-EE0000?logo=redhat&logoColor=white&style=flat-square) **Bastion OS** | Red Hat Enterprise Linux | `9.x` | Bastion/helper node OS |
| ![HAProxy](https://img.shields.io/badge/-HAProxy-1f8dd6?style=flat-square) **Load Balancer** | HAProxy | `2.x` | API server + Ingress traffic routing |
| ![Quay](https://img.shields.io/badge/-Quay-40B4E5?style=flat-square) **Registry** | Quay (Internal Mirror) | `3.x` | Pre-mirrored OCP + operator images |
| ![Apache](https://img.shields.io/badge/-Apache-D22128?logo=apache&logoColor=white&style=flat-square) **Ignition** | Apache HTTPD | `2.4` | Serves bootstrap/master/worker `.ign` |
| ![BIND](https://img.shields.io/badge/-BIND_DNS-009933?style=flat-square) **DNS** | BIND9 | `9.x` | Forward + reverse DNS for all nodes |
| ![NTP](https://img.shields.io/badge/-Chrony-666666?style=flat-square) **Time** | Chrony NTP | — | Time sync across all nodes (etcd requirement) |
| ![oc-mirror](https://img.shields.io/badge/-oc--mirror-cc0000?logo=redhatopenshift&logoColor=white&style=flat-square) **Mirroring** | oc-mirror | `v2` | Images + OLM catalog mirroring |
| ![etcd](https://img.shields.io/badge/-etcd-419EDA?style=flat-square) **State Store** | etcd | `v3.5.x` | Cluster state storage (3-node quorum) |
| ![CRI-O](https://img.shields.io/badge/-CRI--O-396DA4?style=flat-square) **Runtime** | CRI-O | `1.31.x` | Container runtime on RHCOS nodes |
| ![OVN](https://img.shields.io/badge/-OVN_Kubernetes-326CE5?style=flat-square) **CNI** | OVN-Kubernetes | — | Default SDN/CNI for pod networking |

</div>

---

## 🏗️ Full Cluster Architecture

### 🌐 Network Topology

```
╔═══════════════════════════════════════════════════════════════════════════════╗
║                     DISCONNECTED OCP 4.18 — NETWORK TOPOLOGY                 ║
╠═══════════════════════════════════════════════════════════════════════════════╣
║                                                                               ║
║   MANAGEMENT NETWORK (192.168.1.0/24)                                         ║
║   ─────────────────────────────────────                                       ║
║   ┌──────────────┐    ┌──────────────┐    ┌──────────────────────────────┐   ║
║   │   Bastion /  │    │  HAProxy LB  │    │       Internal Services       │   ║
║   │  Helper Node │    │              │    │                              │   ║
║   │ 192.168.1.5  │    │ 192.168.1.10 │    │  DNS:      192.168.1.5       │   ║
║   │              │    │              │    │  NTP:      192.168.1.5       │   ║
║   │ ▸ oc-mirror  │    │ Frontend:    │    │  Registry: 192.168.1.5:8443  │   ║
║   │ ▸ openshift- │    │  :6443 API   │    │  Ignition: 192.168.1.5:8080  │   ║
║   │   install    │    │  :22623 MCS  │    └──────────────────────────────┘   ║
║   │ ▸ Quay Reg.  │    │  :443 HTTPS  │                                       ║
║   │ ▸ Apache     │    │  :80  HTTP   │                                       ║
║   │ ▸ BIND DNS   │    └──────┬───────┘                                       ║
║   └──────────────┘           │                                               ║
║                              │ routes to                                     ║
║   CLUSTER NETWORK (192.168.1.0/24)                                            ║
║   ────────────────────────────────                                            ║
║        ┌─────────────────────┼──────────────────────────────────┐            ║
║        │                     │                                  │            ║
║        ▼                     ▼                                  ▼            ║
║  ┌───────────┐     ┌─────────────────────────────┐    ┌────────────────────┐ ║
║  │ Bootstrap │     │       Control Plane          │    │    Worker Nodes    │ ║
║  │           │     │                             │    │                    │ ║
║  │.20        │     │ master-1  master-2  master-3 │    │ worker-1  worker-2 │ ║
║  │ (remove   │     │ .21       .22       .23      │    │ .31       .32      │ ║
║  │  after    │     │                             │    │                    │ ║
║  │  install) │     │ ← etcd quorum: 3 members →  │    │ ← app workloads →  │ ║
║  └───────────┘     └─────────────────────────────┘    └────────────────────┘ ║
║                                                                               ║
║   POD NETWORK    : 10.128.0.0/14  (OVN-Kubernetes)                           ║
║   SERVICE CIDR   : 172.30.0.0/16                                              ║
║   HOST NETWORK   : 192.168.1.0/24                                             ║
╚═══════════════════════════════════════════════════════════════════════════════╝
```

---

### 🔗 Component Interaction Map

```
                    ┌──────────────────────────────────────────────────┐
                    │                BASTION NODE                      │
                    │  ┌──────────┐  ┌──────────┐  ┌──────────────┐   │
                    │  │   Quay   │  │  Apache  │  │   BIND DNS   │   │
                    │  │ Registry │  │  HTTPD   │  │              │   │
                    │  │ :8443    │  │  :8080   │  │ Forward DNS  │   │
                    │  │          │  │          │  │ Reverse DNS  │   │
                    │  │ All OCP  │  │ .ign     │  │ SRV records  │   │
                    │  │ images   │  │  files   │  │ etcd._tcp    │   │
                    │  └────┬─────┘  └────┬─────┘  └──────┬───────┘   │
                    └───────┼─────────────┼────────────────┼───────────┘
                            │             │                │
                    ┌───────┼─────────────┼────────────────┼───────────┐
                    │       │      HAProxy LB               │           │
                    │       │  ┌──────────────────────┐    │           │
                    │       │  │ :6443  → masters x3  │    │           │
                    │       │  │ :22623 → masters x3  │    │           │
                    │       │  │ :443   → workers x2  │    │           │
                    │       │  │ :80    → workers x2  │    │           │
                    │       │  └──────────────────────┘    │           │
                    └───────┼─────────────────────────────┼────────────┘
                            │                              │
          ┌─────────────────┼──────────────┐              │
          │                 │              │              │
          ▼                 ▼              ▼              ▼
    ┌──────────┐     ┌──────────┐  ┌──────────┐  ┌──────────┐
    │Bootstrap │     │ Master-1 │  │ Master-2 │  │ Master-3 │
    │          │     │          │  │          │  │          │
    │Pulls:    │     │  etcd    │  │  etcd    │  │  etcd    │
    │ .ign     │     │  apisvr  │  │  apisvr  │  │  apisvr  │
    │ images   │     │  sched   │  │  sched   │  │  sched   │
    │          │     │  ctrl-mgr│  │  ctrl-mgr│  │  ctrl-mgr│
    │Exits:    │     └────┬─────┘  └──────────┘  └──────────┘
    │ after    │          │ etcd quorum formed
    │ masters  │          │
    │ are up   │          ▼
    └──────────┘    ┌──────────────────────────┐
                    │    Worker Nodes join       │
                    │                          │
                    │  worker-1     worker-2   │
                    │  ┌────────┐  ┌────────┐  │
                    │  │CRI-O   │  │CRI-O   │  │
                    │  │kubelet │  │kubelet │  │
                    │  │OVN-K8s │  │OVN-K8s │  │
                    │  └────────┘  └────────┘  │
                    └──────────────────────────┘
```

---

### 🔄 Boot Sequence Flow

```
BOOTSTRAP NODE BOOTS
       │
       ├─ Fetches bootstrap.ign from Apache HTTPD
       ├─ Pulls images from internal Quay registry
       ├─ Starts temporary etcd
       ├─ Starts temporary API server
       └─ Renders master ignition configs
              │
              ▼
MASTER NODES BOOT (all 3 simultaneously)
       │
       ├─ Fetch master.ign from Apache HTTPD (URL embedded in ignition)
       ├─ Pull images from internal Quay (imageDigestSources redirect)
       ├─ Start etcd — waits for quorum (needs 2/3 peers)
       ├─ Start API server, scheduler, controller-manager
       └─ etcd quorum achieved → permanent control plane ready
              │
              ▼
BOOTSTRAP NODE SELF-DESTRUCTS (safe to remove)
       │
       └─ openshift-install wait-for bootstrap-complete
              │
              ▼
WORKER NODES BOOT
       │
       ├─ Fetch worker.ign from Apache HTTPD
       ├─ Pull images from internal Quay
       ├─ kubelet starts — submits CSR Round 1 (node bootstrapper)
       ├─ Admin approves CSR Round 1 → node gets client cert
       ├─ kubelet submits CSR Round 2 (serving cert)
       ├─ Admin approves CSR Round 2 → node gets serving cert
       └─ Workers join cluster → status: Ready
              │
              ▼
CLUSTER OPERATIONAL ✅
       │
       └─ openshift-install wait-for install-complete
```

---

## 📋 Deployment Phases — Overview

<div align="center">

```
╔══════════╦══════════════════════╦══════════════════════╦══════════════════════╗
║ PHASE 01 ║      PHASE 02        ║      PHASE 03        ║      PHASE 04        ║
║          ║                      ║                      ║                      ║
║  PREP    ║  INFRASTRUCTURE      ║  INSTALLATION        ║  VERIFICATION        ║
║          ║                      ║                      ║                      ║
║ Step 01  ║  Step 04             ║  Step 08             ║  Step 14             ║
║ Step 02  ║  Step 05             ║  Step 09             ║  Step 15             ║
║ Step 03  ║  Step 06             ║  Step 10             ║                      ║
║          ║  Step 07             ║  Step 11             ║                      ║
║          ║                      ║  Step 12             ║                      ║
║          ║                      ║  Step 13             ║                      ║
╠══════════╬══════════════════════╬══════════════════════╬══════════════════════╣
║ ▸ Reqs   ║ ▸ Mirror Registry    ║ ▸ Ignition gen       ║ ▸ Cluster health     ║
║ ▸ DNS    ║ ▸ oc-mirror images   ║ ▸ Bootstrap boot     ║ ▸ Operator status    ║
║ ▸ PKI    ║ ▸ HAProxy LB        ║ ▸ Master boot        ║ ▸ Go-live sign-off   ║
║          ║ ▸ install-config     ║ ▸ Worker boot        ║                      ║
║          ║                      ║ ▸ Bootstrap complete ║                      ║
║          ║                      ║ ▸ CSR approval       ║                      ║
╚══════════╩══════════════════════╩══════════════════════╩══════════════════════╝
```

</div>

---

## 📖 Complete 15-Step Deployment Walkthrough

---

### 🟧 Phase 01 — Preparation (Steps 01–03)

<details>
<summary><b>📌 Step 01 — Environment Planning & Node Inventory</b></summary>

#### What You're Doing
Before touching a single config file, map your entire environment:

**Node Inventory**

| Role | Hostname | IP | CPU | RAM | Disk |
|:-----|:---------|:---|:---:|:---:|:----:|
| Bastion | bastion.ocp.internal | 192.168.1.5 | 8 | 16GB | 500GB |
| HAProxy | lb.ocp.internal | 192.168.1.10 | 4 | 8GB | 100GB |
| Bootstrap | bootstrap.ocp.internal | 192.168.1.20 | 4 | 16GB | 120GB |
| Master-1 | master-1.ocp.internal | 192.168.1.21 | 8 | 32GB | 120GB |
| Master-2 | master-2.ocp.internal | 192.168.1.22 | 8 | 32GB | 120GB |
| Master-3 | master-3.ocp.internal | 192.168.1.23 | 8 | 32GB | 120GB |
| Worker-1 | worker-1.ocp.internal | 192.168.1.31 | 16 | 64GB | 200GB |
| Worker-2 | worker-2.ocp.internal | 192.168.1.32 | 16 | 64GB | 200GB |

**DNS Records Required (BIND)**
```
; Forward zone — ocp.internal
api.ocp.internal.          IN A   192.168.1.10
api-int.ocp.internal.      IN A   192.168.1.10
*.apps.ocp.internal.       IN A   192.168.1.10
bootstrap.ocp.internal.    IN A   192.168.1.20
master-1.ocp.internal.     IN A   192.168.1.21
master-2.ocp.internal.     IN A   192.168.1.22
master-3.ocp.internal.     IN A   192.168.1.23
worker-1.ocp.internal.     IN A   192.168.1.31
worker-2.ocp.internal.     IN A   192.168.1.32

; etcd SRV records (required by installer)
_etcd-server-ssl._tcp.ocp.internal. 86400 IN SRV 0 10 2380 etcd-0.ocp.internal.
_etcd-server-ssl._tcp.ocp.internal. 86400 IN SRV 0 10 2380 etcd-1.ocp.internal.
_etcd-server-ssl._tcp.ocp.internal. 86400 IN SRV 0 10 2380 etcd-2.ocp.internal.

etcd-0.ocp.internal. IN CNAME master-1.ocp.internal.
etcd-1.ocp.internal. IN CNAME master-2.ocp.internal.
etcd-2.ocp.internal. IN CNAME master-3.ocp.internal.
```

> ⚠️ **DNS must be 100% correct before you run the installer.** The installer validates DNS at startup and fails immediately if records are wrong or missing.

</details>

<details>
<summary><b>📌 Step 02 — PKI Setup — Build Your Internal CA Chain</b></summary>

#### What You're Doing
Generate a 3-layer PKI: **Root CA → Intermediate CA → Leaf certs** for registry, API, and ingress.

```bash
# ── Root CA ──────────────────────────────────────────────────────────────────
openssl genrsa -out rootCA.key 4096
openssl req -x509 -new -nodes -key rootCA.key -sha256 -days 3650 \
  -out rootCA.crt \
  -subj "/C=IN/O=Internal/CN=OCP-Internal-Root-CA"

# ── Registry Certificate ──────────────────────────────────────────────────────
openssl genrsa -out registry.key 2048
openssl req -new -key registry.key \
  -out registry.csr \
  -subj "/CN=bastion.ocp.internal"

openssl x509 -req -in registry.csr -CA rootCA.crt -CAkey rootCA.key \
  -CAcreateserial -out registry.crt -days 825 -sha256 \
  -extfile <(printf "subjectAltName=DNS:bastion.ocp.internal,IP:192.168.1.5")

# ── Trust the root CA on bastion ─────────────────────────────────────────────
cp rootCA.crt /etc/pki/ca-trust/source/anchors/
update-ca-trust extract
```

> 🔐 **This rootCA.crt will be embedded in `install-config.yaml` under `additionalTrustBundle`** so every node in the cluster trusts your registry.

</details>

<details>
<summary><b>📌 Step 03 — Download OpenShift Tools & Pull Secret</b></summary>

#### What You're Doing
Download all required binaries on bastion **before** disconnecting from the internet.

```bash
# ── Download from Red Hat (requires RHEL subscription) ────────────────────────
# openshift-install
# oc CLI
# oc-mirror plugin
# RHCOS ISO / PXE images
# openshift-install-linux-amd64.tar.gz

# Extract tools
tar xvf openshift-install-linux.tar.gz
tar xvf openshift-client-linux.tar.gz
tar xvf oc-mirror.tar.gz

mv openshift-install oc kubectl oc-mirror /usr/local/bin/
chmod +x /usr/local/bin/{openshift-install,oc,kubectl,oc-mirror}

# Verify
openshift-install version
oc version
oc-mirror version

# Download pull secret from console.redhat.com
# Save as: /root/pull-secret.json
```

</details>

---

### 🔧 Phase 02 — Infrastructure Setup (Steps 04–07)

<details>
<summary><b>📌 Step 04 — Setup Internal Quay Mirror Registry</b></summary>

#### What You're Doing
Install and configure Quay as your internal mirror. This is the **single most critical step** — if the registry is broken, nothing else matters.

```bash
# ── Install mirror-registry (Red Hat's bundled Quay installer) ────────────────
./mirror-registry install \
  --quayHostname bastion.ocp.internal \
  --quayRoot /opt/quay \
  --initUser admin \
  --initPassword 'SecureP@ss123!' \
  --sslCert /root/certs/registry.crt \
  --sslKey /root/certs/registry.key

# ── Verify registry is running ────────────────────────────────────────────────
curl -u admin:'SecureP@ss123!' \
  https://bastion.ocp.internal:8443/v2/_catalog

# ── Create auth for oc-mirror ─────────────────────────────────────────────────
podman login bastion.ocp.internal:8443 \
  -u admin -p 'SecureP@ss123!' \
  --authfile /root/pull-secret-merged.json
```

</details>

<details>
<summary><b>📌 Step 05 — Mirror OCP Images with oc-mirror</b></summary>

#### What You're Doing
Use `oc-mirror` to pull all OCP 4.18 release images from the internet and push them to your internal Quay. This is done on a **connected bastion**, then the data is transported to the air-gapped environment.

**ImageSetConfiguration (oc-mirror v2)**

```yaml
# imageset-config.yaml
apiVersion: mirror.openshift.io/v2alpha1
kind: ImageSetConfiguration
mirror:
  platform:
    channels:
    - name: stable-4.18
      type: ocp
      minVersion: 4.18.0
      maxVersion: 4.18.5
    graph: true
  operators:
  - catalog: registry.redhat.io/redhat/redhat-operator-index:v4.18
    packages:
    - name: cluster-logging
    - name: elasticsearch-operator
    - name: advanced-cluster-management
    - name: local-storage-operator
  additionalImages:
  - name: registry.redhat.io/ubi9/ubi:latest
  - name: registry.redhat.io/ubi9/ubi-minimal:latest
```

```bash
# ── Run oc-mirror (internet-connected side) ───────────────────────────────────
oc-mirror --config imageset-config.yaml \
  file:///mnt/mirror-data \
  --dest-skip-tls

# ── Transport to air-gapped bastion (USB / secure file transfer) ──────────────
# rsync, scp, or physical media

# ── Push from file to internal registry (air-gapped side) ────────────────────
oc-mirror --from /mnt/mirror-data \
  docker://bastion.ocp.internal:8443 \
  --dest-skip-tls

# ── Collect imageDigestSources output ─────────────────────────────────────────
# oc-mirror generates: oc-mirror-workspace/results-*/
# Contains: imageDigestMirrorSet.yaml → paste into install-config.yaml
```

> 💡 **oc-mirror generates the exact `imageDigestSources` block you need for `install-config.yaml`** — don't write it manually.

</details>

<details>
<summary><b>📌 Step 06 — Configure HAProxy Load Balancer</b></summary>

#### What You're Doing
Configure HAProxy to route cluster traffic across 4 frontend/backend pairs.

```haproxy
# /etc/haproxy/haproxy.cfg

global
    log         127.0.0.1 local2
    maxconn     4000
    daemon

defaults
    mode        tcp
    log         global
    option      tcplog
    option      dontlognull
    retries     3
    timeout     connect  5s
    timeout     client   1m
    timeout     server   1m

#──────────────────────────────────────────────
# FRONTEND — Kubernetes API Server
#──────────────────────────────────────────────
frontend ocp-api-server
    bind *:6443
    default_backend ocp-api-server-be

backend ocp-api-server-be
    balance     roundrobin
    server      bootstrap 192.168.1.20:6443 check
    server      master-1  192.168.1.21:6443 check
    server      master-2  192.168.1.22:6443 check
    server      master-3  192.168.1.23:6443 check

#──────────────────────────────────────────────
# FRONTEND — Machine Config Server (bootstrap only initially)
#──────────────────────────────────────────────
frontend ocp-machine-config-server
    bind *:22623
    default_backend ocp-machine-config-server-be

backend ocp-machine-config-server-be
    balance     roundrobin
    server      bootstrap 192.168.1.20:22623 check
    server      master-1  192.168.1.21:22623 check
    server      master-2  192.168.1.22:22623 check
    server      master-3  192.168.1.23:22623 check

#──────────────────────────────────────────────
# FRONTEND — HTTPS Ingress
#──────────────────────────────────────────────
frontend ocp-https-ingress
    bind *:443
    default_backend ocp-https-ingress-be

backend ocp-https-ingress-be
    balance     roundrobin
    server      worker-1  192.168.1.31:443 check
    server      worker-2  192.168.1.32:443 check

#──────────────────────────────────────────────
# FRONTEND — HTTP Ingress
#──────────────────────────────────────────────
frontend ocp-http-ingress
    bind *:80
    default_backend ocp-http-ingress-be

backend ocp-http-ingress-be
    balance     roundrobin
    server      worker-1  192.168.1.31:80 check
    server      worker-2  192.168.1.32:80 check
```

```bash
systemctl enable --now haproxy
systemctl status haproxy
```

</details>

<details>
<summary><b>📌 Step 07 — Create install-config.yaml</b></summary>

#### What You're Doing
The single most important file in the entire deployment. One wrong field = failed install.

```yaml
# install-config.yaml
apiVersion: v1
baseDomain: internal                        # ← your base domain
metadata:
  name: ocp                                 # ← cluster name (FQDN = ocp.internal)

networking:
  networkType: OVNKubernetes
  clusterNetwork:
  - cidr: 10.128.0.0/14
    hostPrefix: 23
  serviceNetwork:
  - 172.30.0.0/16
  machineNetwork:
  - cidr: 192.168.1.0/24

controlPlane:
  name: master
  replicas: 3                               # ← always 3 for HA etcd quorum
  platform: {}
  hyperthreading: Enabled

compute:
- name: worker
  replicas: 0                               # ← 0 = UPI (you boot workers manually)
  platform: {}
  hyperthreading: Enabled

platform:
  none: {}                                  # ← bare metal UPI = none

pullSecret: |                               # ← merged pull secret with internal registry
  {"auths":{"bastion.ocp.internal:8443":{"auth":"..."},"cloud.openshift.com":{"auth":"..."}}}

sshKey: |                                   # ← bastion's public SSH key
  ssh-rsa AAAAB3Nza... root@bastion

additionalTrustBundle: |                    # ← your internal Root CA cert
  -----BEGIN CERTIFICATE-----
  MIIFxTCCA62gAwIBAgI...
  -----END CERTIFICATE-----

imageDigestSources:                         # ← generated by oc-mirror, DO NOT write manually
- mirrors:
  - bastion.ocp.internal:8443/openshift/release
  source: quay.io/openshift-release-dev/ocp-release
- mirrors:
  - bastion.ocp.internal:8443/openshift/release
  source: quay.io/openshift-release-dev/ocp-v4.0-art-dev
```

> ⚠️ **Back up this file immediately after creation** — the installer consumes and deletes it!

```bash
cp install-config.yaml install-config.yaml.bak
```

</details>

---

### ☸️ Phase 03 — Cluster Installation (Steps 08–13)

<details>
<summary><b>📌 Step 08 — Generate Ignition Configs</b></summary>

```bash
mkdir -p /root/ocp-install
cp install-config.yaml /root/ocp-install/

openshift-install create ignition-configs \
  --dir /root/ocp-install

# Output files generated:
# /root/ocp-install/bootstrap.ign
# /root/ocp-install/master.ign
# /root/ocp-install/worker.ign
# /root/ocp-install/auth/kubeconfig
# /root/ocp-install/auth/kubeadmin-password
# /root/ocp-install/metadata.json

# Serve ignition files via Apache
cp /root/ocp-install/*.ign /var/www/html/
chmod 644 /var/www/html/*.ign
restorecon -v /var/www/html/*.ign

# Verify reachable
curl http://bastion.ocp.internal:8080/bootstrap.ign | python3 -m json.tool | head -5
```

</details>

<details>
<summary><b>📌 Step 09 — Serve RHCOS & Boot Bootstrap</b></summary>

```bash
# Option A: ISO boot — embed ignition URL
coreos-installer iso ignition embed \
  -i /root/ocp-install/bootstrap.ign \
  rhcos-4.18.x-x86_64-live.iso \
  -o bootstrap-live.iso

# Option B: PXE boot — pass ignition URL as kernel arg
# coreos.inst.ignition_url=http://bastion.ocp.internal:8080/bootstrap.ign

# Boot bootstrap node from ISO/PXE
# Monitor bootstrap progress from bastion:
openshift-install wait-for bootstrap-complete \
  --dir /root/ocp-install \
  --log-level=info
```

</details>

<details>
<summary><b>📌 Step 10 — Boot Master Nodes (Strict Order!)</b></summary>

```bash
# Boot all 3 masters from RHCOS ISO/PXE with master.ign
# kernel args example:
# coreos.inst.ignition_url=http://bastion.ocp.internal:8080/master.ign

# Watch etcd cluster form on master-1
ssh core@master-1.ocp.internal
sudo crictl ps | grep etcd
sudo journalctl -u etcd -f

# From bastion — watch nodes appear
export KUBECONFIG=/root/ocp-install/auth/kubeconfig
oc get nodes -w
```

</details>

<details>
<summary><b>📌 Step 11 — Wait for Bootstrap Complete</b></summary>

```bash
# This command blocks until bootstrap is safe to remove
openshift-install wait-for bootstrap-complete \
  --dir /root/ocp-install \
  --log-level=debug

# Expected output:
# INFO It is now safe to remove the bootstrap resources
# INFO Time elapsed: 18m32s

# Remove bootstrap from HAProxy backends (edit haproxy.cfg)
# Comment out the bootstrap server lines, then:
systemctl reload haproxy
```

</details>

<details>
<summary><b>📌 Step 12 — Boot Worker Nodes</b></summary>

```bash
# Boot worker nodes from RHCOS ISO/PXE with worker.ign
# coreos.inst.ignition_url=http://bastion.ocp.internal:8080/worker.ign

# Watch workers appear (they'll be in NotReady until CSRs approved)
oc get nodes -w
```

</details>

<details>
<summary><b>📌 Step 13 — Approve CSRs (Two Rounds!) ⚠️ CRITICAL</b></summary>

```bash
# ── Round 1 — Node Bootstrapper CSRs ─────────────────────────────────────────
oc get csr
# NAME        AGE   SIGNERNAME                                    REQUESTOR              CONDITION
# csr-xxxxx   1m    kubernetes.io/kube-apiserver-client-kubelet   system:node:worker-1   Pending

# Approve all pending CSRs
oc get csr -o go-template='{{range .items}}{{if not .status}}{{.metadata.name}}{{"\n"}}{{end}}{{end}}' \
  | xargs oc adm certificate approve

# ── Wait 2–3 minutes, then Round 2 — Serving CSRs ────────────────────────────
oc get csr
# New pending CSRs will appear for serving certs

oc get csr -o go-template='{{range .items}}{{if not .status}}{{.metadata.name}}{{"\n"}}{{end}}{{end}}' \
  | xargs oc adm certificate approve

# Verify workers are Ready
oc get nodes
# NAME       STATUS   ROLES    AGE   VERSION
# master-1   Ready    master   45m   v1.31.10
# master-2   Ready    master   45m   v1.31.10
# master-3   Ready    master   44m   v1.31.10
# worker-1   Ready    worker   5m    v1.31.10
# worker-2   Ready    worker   5m    v1.31.10
```

> ⚠️ **If you miss Round 2, workers stay in `NotReady` forever.** Set a 3-minute timer after Round 1 approval.

</details>

---

### ✅ Phase 04 — Verification & Go-Live (Steps 14–15)

<details>
<summary><b>📌 Step 14 — Cluster Health Verification</b></summary>

```bash
# ── Wait for install complete ─────────────────────────────────────────────────
openshift-install wait-for install-complete \
  --dir /root/ocp-install \
  --log-level=info

# ── Node status ───────────────────────────────────────────────────────────────
oc get nodes -o wide

# ── All cluster operators must be Available=True, Degraded=False ──────────────
oc get clusteroperators
# NAME                       AVAILABLE   PROGRESSING   DEGRADED
# authentication             True        False         False
# console                    True        False         False
# dns                        True        False         False
# etcd                       True        False         False
# ...

# ── etcd health ───────────────────────────────────────────────────────────────
oc -n openshift-etcd exec $(oc get pods -n openshift-etcd -l app=etcd \
  -o jsonpath='{.items[0].metadata.name}') \
  -- etcdctl endpoint health \
  --endpoints=https://localhost:2379 \
  --cacert=/etc/kubernetes/static-pod-certs/configmaps/etcd-serving-ca/ca-bundle.crt \
  --cert=/etc/kubernetes/static-pod-certs/secrets/etcd-all-certs/etcd-serving-master-1.ocp.internal.crt \
  --key=/etc/kubernetes/static-pod-certs/secrets/etcd-all-certs/etcd-serving-master-1.ocp.internal.key

# ── Check image pull source (verify disconnected routing works) ───────────────
oc debug node/worker-1.ocp.internal -- \
  chroot /host crictl images | grep bastion
```

</details>

<details>
<summary><b>📌 Step 15 — Go-Live Sign-Off Checklist</b></summary>

```bash
# ✅ All nodes Ready
oc get nodes | grep -v Ready  # Should return nothing

# ✅ All cluster operators available
oc get co | grep -v "True.*False.*False"  # Should return nothing

# ✅ Console accessible
oc whoami --show-console

# ✅ kubeadmin password saved securely
cat /root/ocp-install/auth/kubeadmin-password

# ✅ Registry mirror working
oc run test-pod --image=registry.redhat.io/ubi9/ubi:latest \
  --restart=Never -- echo "Mirror works!"
oc logs test-pod
oc delete pod test-pod

# ✅ Create a test namespace
oc new-project go-live-test
oc new-app --image=bastion.ocp.internal:8443/ubi9/ubi:latest \
  -n go-live-test
oc delete project go-live-test
```

</details>

---

## ⚠️ Critical Steps At a Glance

<div align="center">

```
┌────────┬──────────────────────────┬──────────────────────────────────────────────┐
│  Step  │          What            │              Why It Breaks Everything         │
├────────┼──────────────────────────┼──────────────────────────────────────────────┤
│  04    │  Mirror Registry Setup   │  Any missing image layer = silent fail        │
│  05    │  oc-mirror run           │  Wrong image set = operator installs fail     │
│  06    │  HAProxy Config          │  Missing port 22623 = worker ignition fails   │
│  07    │  install-config.yaml     │  Wrong imageDigestSources = no images pulled  │
│  10    │  Boot Order              │  Bootstrap before masters = etcd never forms  │
│  11    │  Bootstrap Removal       │  Keeping it in HAProxy pollutes API traffic   │
│  13    │  CSR Round 2             │  Workers stuck NotReady forever               │
└────────┴──────────────────────────┴──────────────────────────────────────────────┘
```

</div>

---

## 🔐 Security Deep Dive

### Certificate Chain

```
┌─────────────────────────────────────────────────────────────────────┐
│                    INTERNAL PKI CHAIN                               │
│                                                                     │
│  ┌─────────────────────────────────────┐                           │
│  │  Root CA  (rootCA.crt)              │  ← Self-signed, 10yr      │
│  │  Embedded in additionalTrustBundle  │  ← ALL nodes trust this   │
│  └─────────────────┬───────────────────┘                           │
│                    │ signs                                          │
│                    ▼                                                │
│  ┌─────────────────────────────────────┐                           │
│  │  Registry Leaf Cert (registry.crt)  │  ← 2yr, SAN for bastion   │
│  │  Served by Quay on :8443           │                           │
│  └─────────────────────────────────────┘                           │
│                                                                     │
│  ┌─────────────────────────────────────┐                           │
│  │  OCP generates its own certs for:  │                           │
│  │  ▸ API server (api.ocp.internal)   │                           │
│  │  ▸ Ingress (*.apps.ocp.internal)   │                           │
│  │  ▸ etcd peer-to-peer TLS           │                           │
│  │  ▸ kubelet serving certs           │                           │
│  └─────────────────────────────────────┘                           │
└─────────────────────────────────────────────────────────────────────┘
```

### Digest-Based Image Routing

```
Node requests:
quay.io/openshift-release-dev/ocp-v4.0-art-dev@sha256:abc123...
        │
        │ imageDigestSources intercepts (CRI-O level)
        │
        ▼
bastion.ocp.internal:8443/openshift/release@sha256:abc123...
        │
        │ digest must match — tamper-evident, no tag mutation
        ▼
Image pulled from internal Quay ✅
```

---

## 🗄️ Prerequisites & Resource Requirements

| Resource | Minimum | Recommended |
|:---------|:-------:|:-----------:|
| Bootstrap CPU | 4 vCPU | 4 vCPU |
| Bootstrap RAM | 16 GB | 16 GB |
| Bootstrap Disk | 120 GB | 120 GB |
| Master CPU | 8 vCPU | 16 vCPU |
| Master RAM | 32 GB | 64 GB |
| Master Disk | 120 GB | 200 GB |
| Worker CPU | 8 vCPU | 16+ vCPU |
| Worker RAM | 32 GB | 64+ GB |
| Worker Disk | 120 GB | 200+ GB |
| Registry Disk | 300 GB | 500+ GB |

---

## 🛠️ Troubleshooting Guide

| Symptom | Likely Cause | Fix |
|:--------|:-------------|:----|
| `x509: certificate signed by unknown authority` | Root CA not in trust bundle | Re-embed rootCA in `additionalTrustBundle` |
| Masters timeout waiting for etcd | Boot order wrong / DNS missing | Verify DNS SRV records + boot order |
| Workers stuck `NotReady` | CSR Round 2 not approved | `oc get csr` → approve all pending |
| `ImagePullBackOff` on any pod | imageDigestSources wrong | Re-run oc-mirror, re-generate ignition |
| Port 22623 unreachable | HAProxy missing MCS frontend | Add MCS frontend/backend to haproxy.cfg |
| bootstrap never completes | Missing images in registry | Check `journalctl -u crio` on bootstrap |
| `Unable to connect to the server` | kubeconfig wrong / API LB down | Verify HAProxy :6443 backend health |

---

## 🏭 Who Is This For?

> Disconnected environments are **mandatory** in regulated industries — not optional.

<div align="center">

<table>
<tr>
<td align="center" width="20%">🏦<br/><br/><strong>Banking &<br/>Finance</strong><br/><br/><sub>PCI-DSS & strict network isolation mandates</sub></td>
<td align="center" width="20%">🛡️<br/><br/><strong>Defense &<br/>Government</strong><br/><br/><sub>Classified networks, sovereign cloud, IL4/IL5</sub></td>
<td align="center" width="20%">🏥<br/><br/><strong>Healthcare</strong><br/><br/><sub>HIPAA compliance & data residency laws</sub></td>
<td align="center" width="20%">⚡<br/><br/><strong>Critical<br/>Infrastructure</strong><br/><br/><sub>Power grids, telecom, utilities</sub></td>
<td align="center" width="20%">🏭<br/><br/><strong>Manufacturing</strong><br/><br/><sub>OT/IT air-gap for SCADA & plant networks</sub></td>
</tr>
</table>

</div>

---

## 🗺️ Roadmap

### ✅ v1.0 — Completed (This Guide)
- [x] Full 15-step UPI disconnected deployment walkthrough
- [x] DNS, HAProxy, PKI, ignition config templates
- [x] oc-mirror v2 ImageSetConfiguration
- [x] CSR approval scripts
- [x] Troubleshooting reference

### 🔜 v1.1 — Coming Next
- [ ] **Day-2 Operations** — MachineConfig, node scaling, certificate rotation
- [ ] **Operator Installation** — Logging, Monitoring, ACM fully offline
- [ ] **LDAP / AD Integration** — OAuth identity provider for enterprise auth
- [ ] **Gitops with ArgoCD** — fully disconnected GitOps workflow

### 🔮 v2.0 — Future
- [ ] **IPv6 / Dual-Stack** — disconnected deployment on dual-stack networks
- [ ] **Multi-cluster ACM** — hub + managed cluster setup air-gapped
- [ ] **Ansible Automation** — fully automated disconnected deployment playbook
- [ ] **FIPS Mode** — FIPS 140-2 compliant cluster deployment guide

---

## 📖 Related Article

<div align="center">

[![LinkedIn Article](https://img.shields.io/badge/📖_Read_Full_Breakdown_on-LinkedIn-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/shivang-bhardwaj-7a4516242/)

***"How I Deployed a Fully Disconnected OpenShift 4.18 UPI Cluster — A Complete Breakdown"***

*DNS hell · ignition debugging · CSR approval at 2am · etcd quorum failures — all of it, documented.*

</div>

---

## 👨‍💻 Author

<div align="center">

**Shivang Bhardwaj**

*DevOps Intern @ KubeRox Technologies*
*RHOCP · RHCSA · OpenShift · Kubernetes · Docker · Linux · AWS · Azure · GCP*

<br/>

[![LinkedIn](https://img.shields.io/badge/LinkedIn-shivang--bhardwaj-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/shivang-bhardwaj-7a4516242/)
[![GitHub](https://img.shields.io/badge/GitHub-shivang8123-181717?style=for-the-badge&logo=github&logoColor=white)](https://github.com/shivang8123)
[![Twitter](https://img.shields.io/badge/Twitter-Shivang8123-1DA1F2?style=for-the-badge&logo=twitter&logoColor=white)](https://x.com/Shivang8123)
[![Email](https://img.shields.io/badge/Email-Gmail-EA4335?style=for-the-badge&logo=gmail&logoColor=white)](mailto:thakurshivangbhardwaj@gmail.com)

<br/>

<img src="https://github-readme-stats.vercel.app/api?username=shivang8123&show_icons=true&theme=tokyonight&hide_border=true&count_private=true&bg_color=0d1117&title_color=cc0000&icon_color=cc0000" height="160" alt="GitHub Stats"/>
&nbsp;&nbsp;
<img src="https://github-readme-stats.vercel.app/api/top-langs/?username=shivang8123&layout=compact&theme=tokyonight&hide_border=true&bg_color=0d1117&title_color=cc0000" height="160" alt="Top Languages"/>

<br/>

<img src="https://github-readme-streak-stats.herokuapp.com/?user=shivang8123&theme=tokyonight&hide_border=true&background=0d1117&ring=cc0000&fire=cc0000&currStreakLabel=cc0000" height="160" alt="Streak"/>

</div>

---

<div align="center">

<br/>

> ### *"In connected installs, the cloud fills the gaps.*
> ### *In disconnected installs — every image, cert, and binary is your responsibility.*
> ### *There is no safety net. That's the point."*
>
> — **Shivang Bhardwaj**

<br/>

![Visitor Count](https://komarev.com/ghpvc/?username=shivang8123&label=Profile+Views&color=cc0000&style=for-the-badge)
&nbsp;
[![Stars](https://img.shields.io/github/stars/shivang8123?style=for-the-badge&color=cc0000&logo=github)](https://github.com/shivang8123)

<br/>

<img src="https://capsule-render.vercel.app/api?type=waving&color=0:0d1117,20:1a0000,50:cc0000,80:8B0000,100:0d1117&height=140&section=footer" width="100%"/>

</div>
