import React, { useState } from 'react'
import { createRoot } from 'react-dom/client'
import './style.css'

function App() {
  const [serverTime, setServerTime] = useState('等待后端回应…')
  const [message, setMessage] = useState('点击按钮，让 Spring Boot 告诉你现在几点。')
  const [loading, setLoading] = useState(false)
  const [error, setError] = useState('')

  async function getServerTime() {
    setLoading(true)
    setError('')
    try {
      const response = await fetch('/api/time')
      if (!response.ok) throw new Error('后端暂时没有回应')
      const data = await response.json()
      setServerTime(data.time)
      setMessage(data.message)
    } catch (requestError) {
      setError(`${requestError.message}，请确认 Spring Boot 已运行在 8080 端口。`)
    } finally {
      setLoading(false)
    }
  }

  return (
    <main className="page-shell">
      <div className="glow glow-one" />
      <div className="glow glow-two" />
      <section className="card">
        <div className="eyebrow"><span className="status-dot" /> FRONTEND × BACKEND</div>
        <h1>时间，来自<br /><span>你的后端。</span></h1>
        <p className="intro">一个小小的全栈演示：React 页面发起请求，Spring Boot 返回服务器时间。</p>

        <div className="time-panel">
          <span className="panel-label">SERVER TIME</span>
          <strong>{serverTime}</strong>
          <p>{message}</p>
        </div>

        <button className="action-button" onClick={getServerTime} disabled={loading}>
          {loading ? '正在连接后端…' : '获取后端时间'}
          <span className="arrow">→</span>
        </button>
        {error && <p className="error">{error}</p>}
        <div className="tech-row"><span>Vite</span><i>·</i><span>React</span><i>·</i><span>Spring Boot</span></div>
      </section>
    </main>
  )
}

createRoot(document.getElementById('root')).render(<App />)
