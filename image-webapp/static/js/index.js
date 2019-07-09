const Uppy = require('@uppy/core')
const Dashboard = require('@uppy/dashboard')
const XHRUpload = require('@uppy/xhr-upload')
const Dropbox = require('@uppy/dropbox')

// And their styles (for UI plugins)
require('@uppy/core/dist/style.css')
require('@uppy/dashboard/dist/style.css')

const uppy = Uppy({
    id: 'uppy',
    debug: true,
    autoProceed: false,
    restrictions: {
        maxFileSize: 1000000,
        maxNumberOfFiles: 3,
        minNumberOfFiles: 1,
        allowedFileTypes: ['image/*', 'video/*']
    }
})
    .use(Dashboard, {
        id: 'Dashboard',
        trigger: '.UppyModalOpenerBtn',
        target: '#select-files',
        inline: false,
    })
    .use(XHRUpload, {
        id: 'XHRUpload',
        formData: true,
        endpoint: 'http://local.stage.com:8088/upload/cos',
        method: 'POST'
    })
    .use(Dropbox, { target: Dashboard, companionUrl: 'https://companion.uppy.io' })

uppy.on('complete', (result) => {
    console.log('Upload complete! We’ve uploaded these files:', result.successful)
})